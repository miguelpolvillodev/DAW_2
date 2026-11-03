# Respuestas – Pedidos online

**¿Qué diferencia hay entre `==` e `is` en nuestros productos?**
`==` compara valores: con `dataclass` se genera `__eq__`, así que dos `Producto("TEC", "Teclado", 2500)` son iguales porque tienen los mismos campos. `is` compara identidad: son dos objetos distintos en memoria, por eso `p is not Producto("TEC", "Teclado", 2500)` es `True`.

**¿Qué métodos ha generado `dataclass` y qué reglas has escrito tú?**
`dataclass` genera `__init__`, `__repr__` y `__eq__`; con `frozen=True` además `__setattr__`/`__delattr__` que impiden reasignar campos y `__hash__`. Yo he escrito las reglas en `__post_init__` (código y nombre no vacíos y sin espacios exteriores, precio entero no negativo, cantidad entera positiva, rechazando `bool` y decimales con `type(x) is int`), el `__str__` y la propiedad `subtotal_centimos`.

**¿Por qué devolver una tupla protege mejor la lista interna? ¿Qué límite tiene esa protección?**
`lineas` devuelve `tuple(self._lineas)`, una copia inmutable: quien la recibe no puede hacer `append` ni `del` sobre la lista real, así que solo se cambia mediante `agregar_producto`/`quitar_producto`, que aplican las reglas. Límites: es una copia superficial (los objetos de dentro son los mismos; aquí no importa porque `LineaPedido` y `Producto` son `frozen`), y el `_` es solo una convención: Python no impide escribir `pedido._lineas` desde fuera.

**¿Por qué `Pedido` contiene líneas en lugar de heredar de `LineaPedido`?**
Porque la relación es "un pedido *tiene* líneas" (composición), no "un pedido *es* una línea" (herencia). Un pedido tiene varias líneas, un número y un estado; heredar le daría un `producto` y una `cantidad` que no tienen sentido para él.

**¿Qué cambia entre el ejemplo ABC y el de Protocol? ¿Qué comprueba Python al ejecutar?**
Con `ABC` el contrato es nominal: la clase debe heredar de `Notificador`, y Python comprueba al instanciar que se ha implementado `enviar` (si no, `TypeError`; tampoco se puede instanciar `Notificador`). Con `Protocol` el contrato es estructural: basta con que el objeto tenga `enviar(mensaje: str) -> None`, sin heredar (`NotificadorPrefijo`). Python no comprueba nada al ejecutar: el `Protocol` solo lo usan el editor o un verificador de tipos como mypy; si el objeto no tuviera `enviar`, fallaría con `AttributeError` en el momento de llamarlo.

**¿Qué pasa si el aviso falla después de confirmar?**
`confirmar_y_avisar` confirma primero y avisa después. Si `enviar` lanza, por ejemplo, `RuntimeError`, el pedido ya está `CONFIRMADO` y se queda así (no hay rollback ni reintentos), y la excepción se propaga a quien llamó al servicio, que decide qué hacer. Como el pedido ya está confirmado, volver a llamar a `confirmar_y_avisar` fallaría con `ErrorPedido`, así que el aviso perdido tendría que reenviarse por otra vía.

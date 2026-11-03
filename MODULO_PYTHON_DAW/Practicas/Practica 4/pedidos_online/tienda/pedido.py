from tienda.errores import ErrorPedido
from tienda.linea import LineaPedido
from tienda.producto import Producto

ABIERTO = "ABIERTO"
CONFIRMADO = "CONFIRMADO"
CANCELADO = "CANCELADO"


class Pedido:
    """Contiene líneas (composición) y controla cómo cambian según su estado."""

    def __init__(self, numero: str) -> None:
        if type(numero) is not str or not numero.strip():
            raise ValueError("El número de pedido es obligatorio")
        self._numero = numero.strip()
        self._lineas: list[LineaPedido] = [] 
        self._estado = ABIERTO

    @property
    def numero(self) -> str:
        return self._numero

    @property
    def lineas(self) -> tuple[LineaPedido, ...]:
        return tuple(self._lineas)

    @property
    def total_centimos(self) -> int:
        return sum(linea.subtotal_centimos for linea in self._lineas)

    @property
    def estado(self) -> str:
        return self._estado

    def _exigir_abierto(self) -> None:
        if self._estado != ABIERTO:
            raise ErrorPedido(f"El pedido está {self._estado} y no admite cambios")

    def agregar_producto(self, producto: Producto, cantidad: int) -> None:
        self._exigir_abierto()
        if any(linea.producto.codigo == producto.codigo for linea in self._lineas):
            raise ErrorPedido("El producto ya está en el pedido")
        linea = LineaPedido(producto, cantidad)  # valida la cantidad antes de tocar la lista
        self._lineas.append(linea)

    def quitar_producto(self, codigo: str) -> None:
        self._exigir_abierto()
        for indice, linea in enumerate(self._lineas):
            if linea.producto.codigo == codigo:
                del self._lineas[indice]
                return
        raise ErrorPedido("El producto no está en el pedido")

    def confirmar(self) -> None:
        self._exigir_abierto()
        if not self._lineas:
            raise ErrorPedido("No se puede confirmar un pedido vacío")
        self._estado = CONFIRMADO

    def cancelar(self) -> None:
        if self._estado == CANCELADO:
            raise ErrorPedido("El pedido ya está CANCELADO")
        self._estado = CANCELADO

    def __str__(self) -> str:
        return f"Pedido {self._numero} [{self._estado}] {self.total_centimos} céntimos"

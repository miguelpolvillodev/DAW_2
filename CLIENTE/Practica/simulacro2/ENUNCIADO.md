# SIMULACRO 2 — Entorno Cliente

**Tiempo: 45 minutos.** Solo tus apuntes impresos. No mires tus ejercicios anteriores ni me preguntes nada hasta terminar.
El HTML ya está hecho y **no se puede tocar**. Solo escribes el JS (un `.js` por página).
Antes de escribir código, lee el enunciado entero y haz una lista con un renglón por apartado.

---

## Ejercicio 1 — Pedido de camisetas (formulario sin id, `ej1/js/pedido.js`)

Accede al formulario con `document.forms` y a sus campos con `elements` (por `name`). **Ningún campo tiene id.**

Al pulsar **Enviar** se valida por este orden. Solo se muestra el **primer** error, en **rojo**, en el div `resumen`:

1. Si el nombre está vacío: `Falta el nombre`
2. Si la cantidad está vacía, no es un número, o es menor que 1: `Cantidad no válida`
3. Si no hay talla seleccionada: `Elige una talla`
4. Si no hay forma de pago seleccionada: `Elige forma de pago`

Si todo es correcto:

- En el div `resumen`, en **verde**: `Pedido de NOMBRE: N camisetas talla T, pago P.`
  (NOMBRE, N, T y P son los valores reales; P es el `value` del radio, por ejemplo `tarjeta`.)
- Se pone el campo nombre en blanco y el foco en él.
- El campo cantidad y la talla se quedan como estaban.

---

## Ejercicio 2 — Cuenta atrás en ventana (`ej2/js/principal.js` y `ej2/js/hija.js`)

**index.html** (`principal.js`): al pulsar **Abrir cuenta atrás** se abre `hija.html` en una ventana nueva de 300 x 200.

**hija.html** (`hija.js`): nada más cargar, empieza una cuenta atrás desde **5**.
En el div `contador` se muestra `Quedan N segundos`, que empieza en `Quedan 5 segundos` y baja cada segundo.

- Si se pulsa **Parar**: se para la cuenta, y en el div `contador` se escribe `Parado` **sin cerrar la ventana**.
- Si la cuenta llega a 0: se para, la ventana hija se cierra y en el div `aviso` de la **ventana principal** se escribe en **azul** `Tiempo agotado`.

---

## Al terminar
Pruébalo tú antes de decirme nada: ¿qué pasa si pulsas Enviar con todo vacío? ¿Y con cantidad `0`? ¿Y si pulsas Parar y luego no haces nada? Después me dices "ya".

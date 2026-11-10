# SIMULACRO 1 — Entorno Cliente

**Tiempo: 45 minutos.** Solo tus apuntes impresos. No mires tus ejercicios anteriores ni me preguntes nada hasta terminar.
El HTML ya está hecho y **no se puede tocar**. Solo escribes el JS (un `.js` por página).
Antes de escribir código, lee el enunciado entero y subraya los textos exactos.

---

## Ejercicio 1 — Reserva de entradas (formulario, `ej1/js/reserva.js`)

Al pulsar el botón **Reservar** se valida el formulario **por este orden**. Solo se muestra el **primer** error, en **rojo**, dentro del div `resultado`:

1. Si el nombre está vacío: `Escribe tu nombre`
2. Si las entradas están vacías, no son un número, son menos de 1 o más de 10: `Entradas: de 1 a 10`
3. Si no hay ningún tipo de entrada seleccionado: `Elige un tipo de entrada`

Si todo es correcto:

- El precio de una entrada **general** es 20 y el de una **vip** es 35.
- Se muestra en el div `resultado`, en **verde**:
  `Reserva de NOMBRE: N entradas TIPO. Total: X euros`
  (NOMBRE, N, TIPO y X son los valores reales; el tipo se escribe tal cual está en el `value` del radio, por ejemplo `vip`.)
- Si la casilla de novedades está marcada, se añade al final del mensaje: ` Te avisaremos.`
- Se añade un `li` al `ul` `historial` con el texto `NOMBRE: N entradas`.
  Al hacer clic sobre un `li`, ese `li` se elimina.
- Se vacían los campos nombre y entradas.

---

## Ejercicio 2 — Oferta con cuenta atrás (ventanas + temporizador, `ej2/js/principal.js` y `ej2/js/oferta.js`)

**index.html** (`principal.js`): al pulsar **Ver oferta** se abre `oferta.html` en una ventana nueva de 300 x 200.

**oferta.html** (`oferta.js`): nada más cargar, empieza una cuenta atrás desde 10 segundos.
En el div `cuenta` se muestra `Quedan N segundos` (empieza en `Quedan 10 segundos` y baja cada segundo).

- Si se pulsa **Aceptar**: se para la cuenta, en el div `estado` de la **ventana principal** se escribe en **verde** `Oferta aceptada` y la ventana de la oferta se cierra.
- Si la cuenta llega a 0: se para la cuenta, en el div `estado` de la **ventana principal** se escribe en **rojo** `Oferta caducada` y la ventana de la oferta se cierra.

---

## Al terminar
Pruébalo tú: ¿qué pasa si pulsas Reservar con todo vacío? ¿y con 11 entradas? ¿Y si abres la oferta y no haces nada 10 segundos? Después me dices "ya".

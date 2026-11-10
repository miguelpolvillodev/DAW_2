# Día 1 · Ejercicio 2 — Cuenta atrás en una ventana

Crear una página `index.html` (ya creada) con dos botones ("Empezar" y "Cancelar") y un div con id `fin`.

Al pulsar "Empezar" se abrirá una ventana vacía de 300x150 (sin archivo html: se escribe con JavaScript) con un `h1` con id `cuenta` que muestre el número 10.

Cada segundo, el número del h1 de la ventana irá bajando de uno en uno. Cuando llegue a 0, la ventana se cerrará sola y en el div `fin` de la principal se escribirá, en azul: "Cuenta terminada a las HH:MM:SS" (hora actual).

El botón "Cancelar" detiene la cuenta, cierra la ventana y escribe en `fin`, en rojo: "Cuenta cancelada".

Si se pulsa "Empezar" dos veces seguidas no deben quedar dos cuentas funcionando.

Un solo archivo js: `js/principal.js`.

Trabaja: ventana vacía + `document.write`, `setInterval` con función aparte, `clearInterval` global, escribir en la hija desde la principal sin esperar `load`, hora con `toLocaleTimeString()`.

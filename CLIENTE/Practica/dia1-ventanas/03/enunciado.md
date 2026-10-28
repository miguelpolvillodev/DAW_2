# Día 1 · Ejercicio 3 — Votación

Crear una página `index.html` (ya creada) con un botón "Votar" y un div con id `resultado`.

Al pulsar "Votar" se abrirá una ventana hija de 300x200 (`votar.html`, ya creada) con 3 radio buttons (Betis, Sevilla, Otro) y un botón "Enviar".

En la ventana hija, al pulsar "Enviar":
1. Si no hay ningún equipo marcado se mostrará un alert: "Elige un equipo" y la ventana seguirá abierta.
2. Si hay uno marcado, se escribirá en el div `resultado` de la ventana principal "Has votado: XXX" y la ventana hija se cerrará.

Si en 5 segundos desde que se abre la hija no se ha votado, la ventana principal cerrará la hija y escribirá en `resultado`, en rojo: "Tiempo agotado".

Si se vota a tiempo, no debe aparecer nunca el mensaje de tiempo agotado.

Cada página tendrá su propio archivo js: `js/principal.js` y `js/votar.js`.

Trabaja: `window.opener` en la hija, quién ejecuta qué, `setTimeout` + `clearTimeout` (o comprobar `v.closed`), leer radios, el enunciado COMPLETO.

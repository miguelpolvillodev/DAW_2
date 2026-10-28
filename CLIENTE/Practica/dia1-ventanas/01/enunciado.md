# Día 1 · Ejercicio 1 — Saludo en la ventana hija

Crear una página `index.html` (ya creada) con un input con id `nombre`, un botón y un div con id `mensaje`.

Al pulsar el botón:
1. Si el nombre está vacío se mostrará un alert: "Escribe un nombre" y no se abrirá nada.
2. Si no, se abrirá una ventana hija de 300x200 (`hija.html`, ya creada).
3. En el `h2` de la hija se escribirá "Hola XXX", donde XXX es el nombre del input.

Cuando se pulse el botón "Cerrar" de la ventana hija, la ventana se cerrará y en el div `mensaje` de la ventana principal se escribirá, en letra roja, "Ventana cerrada por el usuario".

Cada página tendrá su propio archivo js: `js/principal.js` y `js/hija.js`.

Trabaja: variable global de la ventana, esperar a que cargue la hija, `window.opener`, cerrar la hija desde la hija.

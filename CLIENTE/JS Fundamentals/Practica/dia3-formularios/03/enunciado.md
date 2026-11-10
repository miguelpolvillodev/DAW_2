# Día 3 · Ejercicio 3 — Registro con validación y tabla

Crear una página `index.html` (ya creada) con un formulario con id `registro` que tiene: nombre (`nombre`), email (`email`), edad (`edad`), contraseña (`pass`), repetir contraseña (`pass2`), un checkbox `terminos` ("Acepto las condiciones") y un botón de tipo submit "Registrar". Debajo, un div con id `mensaje` y una tabla con un `tbody` de id `cuerpo`.

Al enviar el formulario (la página NO debe recargarse) se validará, y solo se mostrará el PRIMER error encontrado, en rojo, en `mensaje`, en este orden:
1. Nombre vacío: "El nombre es obligatorio"
2. Email sin "@" o sin ".": "Email no válido"
3. Edad vacía, no numérica, menor que 18 o mayor que 99: "La edad debe estar entre 18 y 99"
4. Contraseña de menos de 6 caracteres: "La contraseña debe tener al menos 6 caracteres"
5. Las contraseñas no coinciden: "Las contraseñas no coinciden"
6. Condiciones sin aceptar: "Debes aceptar las condiciones"

Si todo es correcto:
- Se escribirá en `mensaje`, en verde: "Registro correcto".
- Se añadirá una fila a la tabla con el nombre, el email y la edad, y un botón "Borrar" que elimina esa fila.
- Se vaciará el formulario y el foco volverá al campo nombre.

Un solo archivo js: `js/registro.js`.

Trabaja: `submit` + `preventDefault()`, cadena de `else if` (primer error), `includes`/`indexOf`, `checked`, `length`, `createElement`/`appendChild`/`remove`, `reset()`, `focus()`.

# 05 · Registro con validación (estilo examen)
(Es el ejercicio 8 del Tema 3.1.)

Valida el formulario **antes de enviarlo** (evento `submit`):

1. `nombre`, `apellidos` y `edad` no pueden estar vacíos (ni solo espacios).
2. `edad` debe ser un número entre 0 y 105.
3. Debe haberse seleccionado una provincia (el valor "0" no vale).
4. Solo se muestra **el primer error** que se encuentre, en el `div#resultado`, en color rojo. Si no hay errores, limpia el div.
5. Si todo es correcto, pregunta con `confirm` si quiere enviar. Si acepta, se envía; si cancela, no se hace nada.
6. Cuando se pulsa *Limpiar* (`reset`), vacía también el `div#resultado`.

Pistas de tus apuntes: `preventDefault`, `submit`, `reset`, `trim()`, `isNaN`, `confirm`, `formulario.submit()`.

# 01 · Formulario: recorrer elements, value, name e id
(Del estilo del ejercicio 8 del Tema 3.2.)

El HTML tiene un formulario con una fecha y tres textos (con valor por defecto) y 4 botones.

1. **Nombres:** al pulsar el botón, recorre con un bucle `form.elements` y muestra con `alert` el `name` de cada elemento (los botones también cuentan).
2. **Solo text:** muestra con `alert` el `name` y el `value` solo de los elementos de tipo `text`.
3. **Nombre completo (id):** `alert` con nombre + apellido1 + apellido2 obteniendo cada campo con `getElementById`.
4. **Nombre completo (name):** lo mismo, pero accediendo por el atributo `name` (a través del formulario).
5. Extra: tras mostrar el nombre completo, deja los textos en blanco con `form.reset()` o con un bucle y pon el foco en el nombre.

Pistas de tus apuntes: formularios → `elements`, `type`, `value`, `focus()`.

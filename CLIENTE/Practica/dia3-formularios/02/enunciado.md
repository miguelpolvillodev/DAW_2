# Día 3 · Ejercicio 2 — Pedido de pizzas

Crear una página `index.html` (ya creada) con un formulario con id `pedido`:
- Tres radio buttons con name `tamano`: Pequeña (6), Mediana (8), Grande (10). El `value` de cada radio es su precio.
- Cuatro checkbox con name `ingrediente` (Queso, Jamón, Champiñones, Piña). Cada ingrediente extra cuesta 1 € y su `value` es su nombre.
- Un select con id `bebida` con las opciones: "Sin bebida" (value 0), "Agua" (value 1), "Refresco" (value 2).
- Un input de texto con id `cantidad` (número de pizzas).
- Un botón "Calcular" y un botón "Limpiar". Y un div con id `total`.

Al pulsar "Calcular":
1. Si no hay tamaño elegido: "Elige un tamaño" (en rojo).
2. Si la cantidad está vacía, no es un entero o es menor que 1: "La cantidad debe ser un número entero mayor que 0" (en rojo).
3. Si todo está bien, se escribirá en `total`, en verde, en dos líneas:
   `Pizzas: N de tamaño TAMAÑO con INGREDIENTES` (los ingredientes separados por coma, o "sin ingredientes extra" si no hay ninguno)
   `Total: X €`
   El total es (precio del tamaño + 1 € por cada ingrediente) × cantidad + el precio de la bebida.

"Limpiar" vacía el formulario y el div `total`.

Un solo archivo js: `js/pedido.js`.

Trabaja: leer un radio, recorrer checkbox y guardar en un array (`push`, `join`), leer un select, convertir `value` a número, `<br>` en `innerHTML`, `reset()`.

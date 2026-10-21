# 06 · Filtrar productos (arrays de objetos + formulario)

El array `productos` ya está en `ejercicio.js`.

1. Al cargar la página, muestra TODOS los productos en `ul#lista` con el formato `Manzana - 1.50 € (fruta)`.
2. Al pulsar *Filtrar*, muestra solo los de la categoría elegida en `#categoria` ("todas" muestra todos).
3. Si `#soloStock` está marcado, deja solo los que tienen `stock > 0`.
4. Debajo, en `#total`, escribe el nº de productos mostrados y el precio medio con 2 decimales. Si no hay ninguno: "No hay productos" en rojo.
5. Usa `filter` y `map` (y `join`), no bucles `for`.
6. Extra: el botón *Ordenar por precio* los ordena de menor a mayor (`sort` con función) sin modificar el array original (pista: `slice()` o `[...productos]`).

Pistas de tus apuntes: métodos de arrays (`filter`, `map`, `join`, `sort`), `innerHTML`, `toFixed`.

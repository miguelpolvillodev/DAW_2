# Día 2 · Ejercicio 2 — Cronómetro

Crear una página `index.html` (ya creada) con un input de texto con id `tiempo` (solo lectura, con el valor inicial "00:00") y tres botones: "Iniciar", "Pausar" y "Reiniciar".

- "Iniciar": el cronómetro empieza a contar segundos y muestra el tiempo en formato MM:SS (siempre con dos dígitos: 00:05, 01:09...). Si ya está en marcha no debe pasar nada.
- "Pausar": detiene el cronómetro sin borrar el tiempo. "Iniciar" continuará desde ahí.
- "Reiniciar": detiene el cronómetro y vuelve a poner "00:00".

Cuando el cronómetro llegue a los 20 segundos, el fondo de la página (`document.body`) se pondrá en rojo y el cronómetro se detendrá. Al reiniciar, el fondo vuelve a su color normal.

Un solo archivo js: `js/cronometro.js`.

Trabaja: contador global, dos dígitos (`if (x < 10) ...`), `clearInterval` en todos los sitios, no duplicar intervalos, parar al llegar a un valor.

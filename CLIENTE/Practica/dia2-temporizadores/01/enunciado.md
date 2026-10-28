# Día 2 · Ejercicio 1 — Semáforo

Crear una página `index.html` (ya creada) con un div con id `luz` (un cuadrado de 100x100) y dos botones: "Parar" y "Reanudar".

Nada más cargar la página, el semáforo empezará a funcionar: cada 2 segundos el div cambiará de color siguiendo el orden rojo → verde → amarillo → rojo... y escribirá dentro el nombre del color ("Rojo", "Verde", "Amarillo").

- El botón "Parar" detiene el semáforo.
- El botón "Reanudar" lo pone en marcha otra vez, desde donde se quedó. Si se pulsa "Reanudar" con el semáforo ya en marcha, no debe pasar nada (no pueden quedar dos temporizadores).

Un solo archivo js: `js/semaforo.js`.

Trabaja: `setInterval` con función declarada aparte, `clearInterval`, variable global, contador con `% 3`, `else if`.

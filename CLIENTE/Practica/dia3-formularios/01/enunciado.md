# Día 3 · Ejercicio 1 — Calculadora de IMC

Crear una página `index.html` (ya creada) con un input de texto con id `peso` (kg), otro con id `altura` (cm), un botón "Calcular" y un div con id `resultado`.

Al pulsar el botón:
1. Si algún campo está vacío, se escribirá en `resultado`, en rojo: "Rellena todos los campos".
2. Si alguno no es un número o es menor o igual que 0, se escribirá en rojo: "Introduce números válidos".
3. Si todo es correcto, se calculará el IMC (peso / (altura en metros)²) y se escribirá en `resultado`, en azul: "Tu IMC es X.XX: CLASIFICACIÓN", con dos decimales y donde CLASIFICACIÓN es:
   - menos de 18.5: "Bajo peso"
   - de 18.5 hasta menos de 25: "Normal"
   - de 25 hasta menos de 30: "Sobrepeso"
   - 30 o más: "Obesidad"

Un solo archivo js: `js/imc.js`.

Trabaja: leer los inputs DENTRO del clic, campo vacío (`== ""` ANTES de `isNaN`), `else if`, `toFixed(2)`, escribir en un elemento (no en una variable), textos exactos del enunciado.

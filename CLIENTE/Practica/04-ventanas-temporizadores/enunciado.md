# 04 · Ventanas y temporizadores

Dos ficheros JS: `principal.js` (ventana padre, `index.html`) y `datos.js` (ventana hija, `datos.html`).

**Ventana principal**
1. *Abrir datos*: abre `datos.html` en una ventana de 400x300, en la posición (100, 100), sin barras de menú, y guarda la referencia en una variable global.
2. *Mover*: mueve la hija 50 px a la derecha y 50 px hacia abajo (`moveBy`); *Agrandar* la agranda 100x100 (`resizeBy`). Llama a `focus()` después. Si la hija está cerrada, avisa en `#resultado`.
3. *Cerrar hija*: la cierra.
4. **Reloj** `#reloj`: muestra la hora actual y se actualiza cada segundo (`setInterval`, `toLocaleTimeString`). El botón *Parar reloj* lo detiene (`clearInterval`).
5. **Aviso**: nada más cargar la página, a los 10 segundos (`setTimeout`) escribe en `#aviso` "Han pasado 10 segundos". Si la ventana hija sigue abierta en ese momento, añade "La ventana de datos sigue abierta".

**Ventana hija**
6. *Mostrar*: escribe en `#resultado` de la ventana PADRE (`window.opener`) el nombre completo y la fecha de nacimiento en formato dd/mm/yyyy. Después cierra la hija.
7. *Cancelar*: cierra la hija sin escribir nada.

Pistas de tus apuntes: ventanas (padre→hija, hija→padre), temporizadores, `Date`.

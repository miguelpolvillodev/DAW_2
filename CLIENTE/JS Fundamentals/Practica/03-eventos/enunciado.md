# 03 · Eventos

Usa **addEventListener** y **funciones flecha** en todo.

1. **Campo nombre (`#nombre`):**
   - `focus` → fondo amarillo; `blur` → fondo blanco y el texto pasa a MAYÚSCULAS.
   - `keyup` → en `#contador` muestra cuántos caracteres lleva escritos.
2. **Botón `#btnColor`:** `mouseover` → borde verde; `mouseout` → borde naranja; `click` → texto azul.
3. **Contador:** `#valor` empieza en 5. *Sumar* suma 1 y *Restar* resta 1. Cuando vale 3, añade el texto "Alcanzado valor 3"; si vuelve a ser distinto de 3, que desaparezca.
4. **Enlace `#enlace`:** al hacer clic, cancela la navegación con `preventDefault`, pregunta con `confirm` y, solo si acepta, ve a la página con `location.href`. Muestra además en `#info` el `event.type` y el `id` del `event.target`.
5. **Botón `#btnQuitar`:** quita el manejador de `click` del botón `#btnColor` (`removeEventListener`, así que el manejador debe ser una función con nombre).
6. Extra: al pulsar cualquier tecla (`keydown` en `document`) muestra en `#info` la tecla (`event.key`).

Pistas de tus apuntes: eventos de ratón / teclado / formulario, objeto `event` (`type`, `target`, `preventDefault`), `removeEventListener`.

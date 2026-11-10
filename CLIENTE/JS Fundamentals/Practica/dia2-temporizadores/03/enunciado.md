# Día 2 · Ejercicio 3 — Anuncios que desaparecen

Crear una página `index.html` (ya creada) con un div con id `anuncio`, otro div con id `contador` y un botón "Parar anuncios".

Nada más cargar la página:
1. Cada 2 segundos, el div `anuncio` mostrará el siguiente de estos mensajes, de forma rotatoria (al llegar al último vuelve al primero): "Oferta 2x1", "Nuevo curso de JavaScript", "Descuentos de otoño", "Última hora".
2. En el div `contador` se mostrará, cada segundo, el número de segundos transcurridos desde que se cargó la página ("Llevas X segundos").
3. A los 10 segundos de cargar la página, el div `anuncio` desaparecerá, se detendrán los dos temporizadores y la página se redirigirá a `fin.html` (ya creada).

El botón "Parar anuncios" detiene solo la rotación de mensajes. El contador sigue funcionando y la redirección a los 10 segundos también.

Un solo archivo js: `js/anuncios.js`.

Trabaja: DOS `setInterval` + un `setTimeout`, tres variables globales, array rotatorio, `style.display = "none"`, `window.location.href`.

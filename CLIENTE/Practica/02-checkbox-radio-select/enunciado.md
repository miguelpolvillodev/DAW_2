# 02 · Checkbox, radio y select

Sin tocar el HTML (ninguno de los checkbox ni radios tiene id):

1. **Sumar extras:** al pulsar *Sumar*, `alert` con la suma de los `value` de los extras marcados. Después deja todos desmarcados.
2. **Talla:** al pulsar *Ver talla*, `alert` con la talla seleccionada. Si no hay ninguna: "Elige una talla".
3. **País:** al pulsar *Ver país*, `alert` con índice, texto y valor de la opción seleccionada.
4. **Aficiones (select múltiple):** al pulsar *Ver aficiones*, `alert` con los textos de las seleccionadas separados por coma. Si no hay ninguna: "Ninguna".
5. **Condiciones:** un checkbox independiente (id `acepto`) con botones *Marcar* y *Desmarcar*.
6. Extra: que el botón *Enviar pedido* solo muestre un `alert("Pedido enviado")` si `acepto` está marcado y hay al menos 1 extra marcado; si no, un mensaje de error en rojo en el `div#mensaje`.

Pistas de tus apuntes: `getElementsByName`, `checked`, `selectedIndex`, `options[i].selected`, `join(", ")`.

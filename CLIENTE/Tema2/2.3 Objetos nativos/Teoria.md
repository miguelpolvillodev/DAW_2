Date Math Number Boolean String

Crear un objeto
let miObjeto = new Objeto_de_javascript();

let fecha = new Date (mes,dia,hora,minutos,segundos);

DATE
Los meses comienzan por 0: Enero es 0 - Diciembre 11

toLocaleDateString() --> 26/12/2050
toLocaleString() --> 26/12/2050 9:30:00
toLocaleTimeString() --> 9:30:00

MATH
Math.floor() --> Redondea hacia abajo 3.74 --> 4
Obtener numero aleatorio entre 2 numeros
Math.floor(Math.random() \* (max - min + 1)) + min

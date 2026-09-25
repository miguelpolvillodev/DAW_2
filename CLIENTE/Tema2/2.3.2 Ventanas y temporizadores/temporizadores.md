Temporizadores declaracion - t en milisegundos
let vTemp = setTimeout(f1,5000);
function f1(){
....
}

Anular temporizador
clearTimeout(vTemp);

Genera un evento cada x milisegundos
let vTemp2 = setInterval(f1,tiempo);
function f1(){
....
}

Cancela el temporizador lanzado con setInterval
clearInterval(vTemp2);

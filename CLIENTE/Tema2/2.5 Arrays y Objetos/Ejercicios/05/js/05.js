var arrayLetras = new Array();
let palabra = prompt("Introduce una palabra")

for (let i = 0; i <= palabra.length -1; i++) {
   arrayLetras.push(palabra.substring(i,i +1));
}

var vocales = arrayLetras.filter(vocal => vocal == 'a' || vocal == 'e' ||vocal == 'i' ||vocal == 'o' || vocal == 'u');

window.document.body.innerHTML += `<p>La palabra ${palabra} tiene ${vocales.length} vocales</p>`;
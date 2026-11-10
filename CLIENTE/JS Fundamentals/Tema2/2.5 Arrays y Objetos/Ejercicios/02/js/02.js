let num = 0;
var arrayP = new Array();
while(num<3){
    let palabra = prompt("Introduce palabra");
    arrayP.push(palabra);
    num++
}
console.log(`Array inicial: ${arrayP}`)
document.write( `Array Inicial: ${arrayP} <br>`);


var c = arrayP.filter(palabras => palabras.startsWith("C") || palabras.startsWith("c") );
if(c.length != 0){
console.log(`Array filtrado:", ${c.join(",")}`);
document.write(`Array filtrado: ${c.join(",")}`);
}else{
    document.write("No hay ninguna palabra que comience por C")
}

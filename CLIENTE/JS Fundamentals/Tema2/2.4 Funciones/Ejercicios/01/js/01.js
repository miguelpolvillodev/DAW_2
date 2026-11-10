function cuadrado(a) {
    return Math.pow(a,2);
}

let acuadrado = function(a){
    return Math.pow(a,2);
}

let ncuadrado = (a) => {
    return Math.pow(a,2);
}

console.log(`Version antigua: `,cuadrado(2));
console.log(`Funcion anonima: `,acuadrado(2))
console.log(`Funcion nueva: `,ncuadrado(2))
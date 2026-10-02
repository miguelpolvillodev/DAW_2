var numero;
while(true){
 numero = prompt("Introduce un numero mayor que 0");
if(numero>0){
    break;
}
}

let sumatorio = (numero) =>{
    let res = 0;
    for (let i = 0; i <= numero ; i++) {
        res += i;
    }

    document.write(`Sumatorio de ${numero} es: ${res}`);
}

sumatorio(numero);
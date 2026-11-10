let num = prompt("Dime un numero")

let factorial = (num) =>{
    let valor = 1;
    for (let i = 1; i <= num; i++) {
        valor *= i;
    }
    return valor;
}

console.log(`El factorial de ${num} es: ${factorial(num)}`);
let numeros = () =>{
    
    for (let index = 0; index < 500; index++) {
      let numA =  Math.floor(Math.random()*(10000 - 1 + 1)) + 1;
        if (numA % 2 == 0) {
            document.write( `<p>Par: ${numA}</p>`);
        }else{
            document.write(`<p>Impar: ${numA}</p>`);
        }
        
    }
    
}

numeros();

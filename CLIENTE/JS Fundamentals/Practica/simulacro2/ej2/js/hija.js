// Escribe aquí tu código
var vTemp;
var cont = 5;

const inicio = () => {
    let contador = window.document.getElementById("contador")
    window.document.getElementById("parar").addEventListener("click", parar)
    contador.innerHTML = `Quedan ${cont} segundos`
  vTemp = setInterval(cerrarVentana, 1000);

  function cerrarVentana() {
    if(cont == 0){
    clearInterval(vTemp)
    window.close()
    let divP = window.opener.document.getElementById("aviso")
    divP.style.color = "blue"
    divP.innerHTML = "Tiempo agotado"
    }else{
    cont--
    contador.innerHTML = `Quedan ${cont} segundos`
    }
    
  }
}

const parar = () => {
  clearInterval(vTemp)
  let contador = window.document.getElementById("contador").innerHTML ="Parado"
}

window.document.addEventListener("DOMContentLoaded", inicio)
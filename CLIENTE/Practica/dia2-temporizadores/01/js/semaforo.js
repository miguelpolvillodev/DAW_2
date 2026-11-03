// Escribe aquí tu código
var vTemp;
var div;

 
const inicio = () => {
  div = window.document.getElementById("luz")
  div.style.backgroundColor = "red"
  div.innerHTML = "Rojo"
  vTemp = setInterval(semaforo, 2000)

  window.document.getElementById("parar").addEventListener("click",parar)
  window.document.getElementById("reanudar").addEventListener("click",reanudar)
 
}

const semaforo = () => {

  if(div.style.backgroundColor == "red"){
    div.style.backgroundColor = "green"
    div.innerHTML = "Verde"
  }else if (div.style.backgroundColor== "green"){
    div.style.backgroundColor = "yellow"
    div.innerHTML ="Amarillo"
  }else{
  div.style.backgroundColor = "red"
  div.innerHTML = "Rojo"
  }
  
   
}

const parar = () => {
  clearInterval(vTemp)
}

const reanudar = () => {
  
  clearInterval(vTemp)                 
  vTemp = setInterval(semaforo, 2000)
}


window.document.addEventListener("DOMContentLoaded", inicio)
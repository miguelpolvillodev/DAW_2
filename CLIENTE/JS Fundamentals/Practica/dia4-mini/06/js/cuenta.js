// Escribe aquí tu código
var vTemp;
var segundos; 
var div;
var cont;

const inicio = () => {
  window.document.getElementById("iniciar").addEventListener("click", temporizador)
}

const validar = () => {
    clearInterval(vTemp)
     div = window.document.getElementById("cuenta")
   segundos = window.document.getElementById("segundos")

  if(segundos.value == "" || isNaN(segundos.value) || segundos.value < 1){
    div.style.color = "red"
    div.innerHTML = "Introduce un número mayor que 0"
    return false
  }else{
     return true
   
  }
}


const temporizador = () => {
  if (validar()){
    cont = segundos.value;
   vTemp = setInterval(t1, 1000)

   function t1 () {
  cont--
  if (cont == 0) {
    clearInterval(vTemp)
    div.style.color = "green"
    div.innerHTML = "¡Tiempo!"
  } else {
    div.style.color = ""
    div.innerHTML = `${cont}`
  }
}
  }
}

window.document.addEventListener("DOMContentLoaded", inicio)
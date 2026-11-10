// Escribe aquí tu código
var texto;

const inicio = () => {
  document.getElementById("enviar").addEventListener("click", enviar)
}

const enviar = () => {
    texto = document.getElementById("texto")
  if(texto.value == ""){
    alert("Escribir un mensaje")
  }else{
    let princ = window.opener.document.getElementById("mensaje")
    princ.style.color = "blue"
    princ.innerHTML = `${texto.value}`
    window.close()
  }
}

window.document.addEventListener("DOMContentLoaded", inicio)

// Escribe aquí tu código
var res;
var v;
var vTemp;

const inicio = () => {
  window.document.getElementById("votar").addEventListener("click", abrirVentana)
  res = window.document.getElementById("resultado");


}



const abrirVentana = () => {
     vTemp = setTimeout(cerrar, 5000)
  v = window.open("votar.html","","width=300px, height=200px")
}

const cerrar = () => {
  v.close()
  res.innerHTML = "Tiempo agotado"
  res.style.color = "red"
}

window.document.addEventListener("DOMContentLoaded", inicio)

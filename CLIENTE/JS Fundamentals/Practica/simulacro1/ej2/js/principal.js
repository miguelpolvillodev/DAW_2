// Escribe aquí tu código
const inicio = () => {
  window.document.getElementById("oferta").addEventListener("click", oferta)
}



const oferta = () => {
  let v = window.open("oferta.html","","width=300px, height=300px")
}

window.document.addEventListener("DOMContentLoaded", inicio)
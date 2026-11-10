// Escribe aquí tu código

const inicio = () => {
  document.getElementById("abrir").addEventListener("click", abrirVentana)
}

const abrirVentana = () => {
  let v = window.open("hija.html","","width=300px, height=200px")
}

window.document.addEventListener("DOMContentLoaded", inicio)

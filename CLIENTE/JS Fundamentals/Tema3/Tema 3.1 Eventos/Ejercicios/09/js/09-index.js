const datos = () => {
nuevaVentana = window.open("datos.html","","width=500px, height=300px")
}

const cargarPagina = () => {
  document.getElementById("abrirPagina").addEventListener("click",datos)
}


window.addEventListener("DOMContentLoaded",cargarPagina)
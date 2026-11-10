

inicio = () => {
  setTimeout(abrirVentana, 5000);


}

const abrirVentana = () => {
  window.open("segunda.html","","width=300, height=300")
}





window.document.addEventListener("DOMContentLoaded", inicio)
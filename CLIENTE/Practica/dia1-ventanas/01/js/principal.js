// Escribe aquí tu código
var nombre;
inicio = () => {
  window.document.getElementById("abrir").addEventListener("click", nuevaVentana)
}

const nuevaVentana = () => {
   nombre = window.document.getElementById("nombre").value

  if(nombre === ""){
    alert("Escribe un nombre")
  }else{
    let v = window.open("hija.html","","width=300px, height=200px")
  }
}


window.document.addEventListener("DOMContentLoaded", inicio)
// Escribe aquí tu código
const inicio = () => {
  let nombre = window.opener.nombre
  document.getElementById("saludo").innerHTML = `Hola ${nombre}`
  document.getElementById("cerrar").addEventListener("click", cerrarPestaña)
}

const cerrarPestaña = () => {
 let respuesta = window.opener.document.getElementById("mensaje")
 respuesta.innerHTML = "Ventana cerrada por el usuario"
 respuesta.style.color = " red"
  window.close();
}

window.document.addEventListener("DOMContentLoaded", inicio)
inicio = () => {
  const padre = document.getElementById("div1")
  const primero = padre.firstElementChild;
  const pNuevo = document.createElement("p")
  pNuevo.innerHTML += `Soy el primero`


  padre.insertBefore(pNuevo, primero )
}



document.addEventListener("DOMContentLoaded", inicio)
inicio = () => {
  const padre = document.getElementById("div1")
  const pNuevo = document.createElement("p")
  
  pNuevo.innerHTML += `Soy el nuevo`

  pNuevo.setAttribute("id", "nuevoP")

  padre.appendChild(pNuevo)
}

window.document.addEventListener("DOMContentLoaded", inicio);
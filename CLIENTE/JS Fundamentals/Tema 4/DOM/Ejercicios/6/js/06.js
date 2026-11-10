inicio = () => {
  let body = document.body
  let p1 = document.createElement("p")
  p1.innerHTML += "parrafo añadido";

  body.appendChild(p1)
}



window.document.addEventListener("DOMContentLoaded", inicio)
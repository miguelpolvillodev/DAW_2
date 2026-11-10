
inicio = () => {
  const p = document.getElementsByTagName("p");

  let body = document.body;

  const pNuevo = document.createElement("p")
  pNuevo.innerHTML += "reemplazado"

  body.replaceChild(pNuevo ,p[0]);
};

window.document.addEventListener("DOMContentLoaded", inicio);
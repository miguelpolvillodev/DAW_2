
inicio = () => {
  let body = document.body

  let ultimo = body.lastElementChild;
  let borrar = ultimo.previousElementSibling;
  body.removeChild(borrar);
}

window.document.addEventListener("DOMContentLoaded", inicio);
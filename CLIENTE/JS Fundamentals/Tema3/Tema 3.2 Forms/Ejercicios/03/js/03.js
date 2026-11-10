iniciarPag = () => {
  window.document.getElementById("boton").addEventListener("click", marcar);

}

marcar = () => {
  let check = window.document.getElementById("check")

  check.checked = true;
}


window.document.addEventListener("DOMContentLoaded", iniciarPag);
iniciarPag = () => {
  window.document.getElementById("boton").addEventListener("click", mostrarNombre);

}

mostrarNombre = () => {
  let texto = window.document.getElementById("texto").value;
    window.document.getElementById("divN").innerHTML += `${texto}`;
window.document.getElementById("texto").value = ''

}


window.document.addEventListener("DOMContentLoaded", iniciarPag);
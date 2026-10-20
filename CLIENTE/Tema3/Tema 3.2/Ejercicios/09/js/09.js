iniciarPag = () => {
  window.document.getElementById("boton").addEventListener("click", mostrarNombre);
  window.document.getElementById("boton").addEventListener("focus", limpiar); 
}

mostrarNombre = () => {
  let texto = window.document.getElementById("texto").value;
    window.document.getElementById("divN").innerHTML += `${texto}`;
}

limpiar = () => {
  window.document.getElementById("texto").value = ''

}

window.document.addEventListener("DOMContentLoaded", iniciarPag);
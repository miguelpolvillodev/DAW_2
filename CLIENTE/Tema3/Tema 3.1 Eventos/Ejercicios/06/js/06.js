
cargarPagina = () => {

  document.getElementById("validar").addEventListener("click",validacion)
}

validacion = () => {
  apellidos = document.getElementById("Apellidos").value;
  nombre = document.getElementById("Nombre").value;
  const palabras = apellidos.trim().split(" ");
  if(nombre.toLowerCase().startsWith("a") || nombre.toLowerCase().startsWith("e") || nombre.toLowerCase().startsWith("i") || nombre.toLowerCase().startsWith("o") || nombre.toLowerCase().startsWith("u")){

  }else{
    document.getElementById("errorNombre").style.color = "red"
    document.getElementById("errorNombre").innerHTML = `No cumple la validación`
  }

  if(palabras.length >= 2){

  }else{
    document.getElementById("errorApellido").style.color = "red"
    document.getElementById("errorApellido").innerHTML = `No cumple la validación`
  }
}
window.addEventListener("DOMContentLoaded",cargarPagina);
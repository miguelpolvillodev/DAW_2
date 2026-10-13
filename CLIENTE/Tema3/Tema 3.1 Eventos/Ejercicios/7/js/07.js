
cargarPagina = () => {

  document.getElementById("validar").addEventListener("click",validacion)
}

validacion = (e) => {
  e.preventDefault();
  apellidos = document.getElementById("Apellidos").value;
  nombre = document.getElementById("Nombre").value;
  const palabras = apellidos.trim().split(" ");
  contador = 0;
  if(nombre.toLowerCase().startsWith("a") || nombre.toLowerCase().startsWith("e") || nombre.toLowerCase().startsWith("i") || nombre.toLowerCase().startsWith("o") || nombre.toLowerCase().startsWith("u")){
  contador ++;
  }else{
  
    document.getElementById("errorNombre").style.color = "red"
    document.getElementById("errorNombre").innerHTML = `No cumple la validación`
  }

  if(palabras.length >= 2){
contador++;
  }else{
    document.getElementById("errorApellido").style.color = "red"
    document.getElementById("errorApellido").innerHTML = `No cumple la validación`

  }
  
if(contador == 2){
  document.getElementById("f1").action="https://www.ceu.es/"
}

}
window.addEventListener("DOMContentLoaded",cargarPagina);
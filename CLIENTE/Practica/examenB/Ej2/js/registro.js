// Escribe aquí tu código
var plan = "";
var nombre;

const inicio = () => {
let form = document.getElementsByName("registro")[0]
form.elements["continuar"].addEventListener("click",abrirVentana)
  
}

const abrirVentana = () => {
  let form = document.getElementsByName("registro")[0]
   nombre = form.elements["nombre"]
  let correo = form.elements["correo"]
  let planes = form.elements["plan"]
  let condiciones = form.elements["condiciones"]
  let div = document.getElementById("error")

  div.style.color = ""
    div.innerHTML = ""
    
    for (let i = 0; i < planes.length; i++) {
  if (planes[i].checked) {
    plan = planes[i].value
  }
}

  if(nombre.value.length < 3 || nombre.value.length > 15){
    div.style.color = "red"
    div.innerHTML = "Error, el nombre tiene que tener entre 3 y 15 caracteres"
  }else if(!correo.value.includes("@") || !correo.value.endsWith(".com")){
    div.style.color = "red"
    div.innerHTML = "Error, correo no contiene @ o no termina en .com"
  }else if(plan == ""){
    div.style.color = "red"
    div.innerHTML = "Error, selecciona un plan"
  }else if(!condiciones.checked){
div.style.color = "red"
    div.innerHTML = "Error, acepta las condiciones"
  }else {
let v = window.open("confirmacion.html","","width=350px, height=250px")
  }
  
}
window.document.addEventListener("DOMContentLoaded", inicio)
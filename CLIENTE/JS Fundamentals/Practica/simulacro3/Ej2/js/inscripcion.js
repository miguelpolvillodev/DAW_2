// Escribe aquí tu código (Ej2 principal)
var nombre;
var curso;
var modalidad;

const inicio = () => {
  let form = document.forms[0]
  form.elements["enviar"].addEventListener("click", enviar)
}
const enviar = () => {
    let form = document.forms[0]
    let div = document.getElementById("error")

     nombre = form.elements["nombre"] 
     curso = form.elements["curso"] 
     modalidad = form.elements["modalidad"] 
    let normas = form.elements["acepto"] 

    div.style.color = ""
    div.innerHTML = ""

    if(nombre.value == "" || nombre.value.length < 3 || nombre.value.length > 12 ){
    div.style.color = "red"
    div.innerHTML = "Nombre no válido"
    }else if (curso.value == ""){
    div.style.color = "red"
    div.innerHTML = "Elige un curso"
    }else if(modalidad.value == ""){
    div.style.color = "red"
    div.innerHTML = "Elige una modalidad"
    }else if (normas.checked == false){
    div.style.color = "red"
    div.innerHTML = "Debes aceptar las normas"
    }else {
    let v = window.open("resumen.html","","width=300px, height=200px")
    }

    
}

window.document.addEventListener("DOMContentLoaded", inicio)
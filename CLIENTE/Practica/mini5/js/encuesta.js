// Escribe aquí tu código

const inicio = () => {
    let form = document.forms[0]
    form.elements["enviar"].addEventListener("click", enviar)
  
}

const enviar = () => {
  let form = document.forms[0]

  let nombre = form.elements["nombre"]
  let turno = form.elements["turno"]
  let nivel = form.elements["nivel"]
  let condiciones = form.elements["acepto"]
  let error = window.document.getElementById("error")
  let res = window.document.getElementById("resultado")

  error.style.color = ""
  error.innerHTML = ""

  let tipoNivel = ""
  for (let i = 0; i < nivel.length; i++) {
    if(nivel[i].checked){
        tipoNivel = nivel[i].value
    }
    
  }

  if(nombre.value < 3 || nombre.value > 10){
    error.style.color = "red"
    error.innerHTML = "Nombre de 3 a 10 caracteres"
  }else if (turno.value == ""){
    error.style.color = "red"
    error.innerHTML = "Elige un turno"
  }else if (tipoNivel == ""){
    error.style.color = "red"
    error.innerHTML = "Elige un nivel"
  }else if (condiciones.checked == false){
    error.style.color = "red"
    error.innerHTML = "Acepta las condiciones"
  }else{
    res.style.color = "green"
    res.innerHTML = "Enviando..."
    vTemp = setTimeout(cerrar, 3000)
    function cerrar() {
        res.style.color = "blue"
    res.innerHTML = "Encuesta enviada"
    }
    
  }
}

window.document.addEventListener("DOMContentLoaded", inicio)
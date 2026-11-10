const inicio = () => {
  window.document.getElementById("btnEnviar").addEventListener("click", enviar)
}


const enviar = (e) => {
  e.preventDefault()
  let nombre = window.document.getElementById("nombre")
  let edad = window.document.getElementById("edad")
  let superPoder = window.document.getElementById("poder")
  let correo = window.document.getElementById("correo")
  let pass = window.document.getElementById("password")
  let confirmPass = window.document.getElementById("confirmPassword")

  const textoPoder = superPoder.value.toLowerCase()
  let vocal = false
  const ultimo = pass.value.charAt(pass.value.length - 1)

  for (let i = 0; i < textoPoder.length; i++) {
    const letra = textoPoder.substring(i, i + 1)
    if (letra === "a" || letra === "e" || letra === "i" || letra === "o" || letra === "u") {
      vocal = true
    }
  }

  if(nombre.value == "" || !isNaN(nombre.value) || nombre.value.length < 3 || nombre.value.length > 20){
    window.document.getElementById("errorNombre").innerHTML = "Nombre incorrecto"
  }else if (edad.value < 18 || edad.value>100){
    window.document.getElementById("errorEdad").innerHTML = "La edad tiene que ser entre 18 y 100 años"
  }else if (superPoder.value.length < 5 || !vocal){
    window.document.getElementById("errorPoder").innerHTML = "Al menos 5 caracteres y una vocal"
  }else if(!correo.value.endsWith(".hero")){
    window.document.getElementById("errorCorreo").innerHTML = "El correo debe terminar en .hero"
  }else if(pass.value.length < 8 || isNaN(ultimo)){
window.document.getElementById("errorPassword").innerHTML = "mínimo 8 caracteres y debe terminar en un número"    
  }else if(confirmPass.value != pass.value){
    window.document.getElementById("errorConfirm").innerHTML = "Las contraseñas tienen que ser iguales"
  }else{
    let confirmacion = confirm("Desea enviar el formulario?")

    if(confirmacion == true){
        setTimeout(mensaje,4000)
        function mensaje() {
            let div = window.document.getElementById("mensajeExito")
            div.innerHTML = `¡Felicidades, ${nombre.value}! Te has unido a la Liga de Superhéroes.`
        }
    }else{

    }
  }
}
window.document.addEventListener("DOMContentLoaded", inicio)
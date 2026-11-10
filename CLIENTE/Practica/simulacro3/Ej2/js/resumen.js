// Escribe aquí tu código (Ej2 ventana)
var cont = 5;
var vTemp;

const inicio = () => {
  let nombre = window.opener.nombre;
  let curso = window.opener.curso;
  let modalidad = window.opener.modalidad;
  window.document.getElementById("datos").innerHTML = `${nombre.value}, curso ${curso.value} (${modalidad.value})`
  window.document.getElementById("aceptar").addEventListener("click", aceptar)

   window.document.getElementById("cuenta").innerHTML = `Quedan ${cont} segundos`

  vTemp = setInterval(cerrarVentana, 1000)
  function cerrarVentana() {
    cont--;
    if(cont == 0){
        clearInterval(vTemp)
        window.close()
        window.opener.document.getElementById("resultado").style.color = "red"
        window.opener.document.getElementById("resultado").innerHTML = "Tiempo Agotado"
    }
    window.document.getElementById("cuenta").innerHTML = `Quedan ${cont} segundos`
  }

}

const aceptar = () => {
  clearInterval(vTemp)
  window.close()
   window.opener.document.getElementById("resultado").style.color = "green"
        window.opener.document.getElementById("resultado").innerHTML = "Inscripción confirmada"
}

window.document.addEventListener("DOMContentLoaded", inicio)
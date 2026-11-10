// Escribe aquí tu código (hija)

var vTemp;
const inicio = () => {
  let textoPadre = window.opener.document.getElementById("texto").value
   window.document.getElementById("eco").innerHTML = textoPadre

   vTemp = setTimeout(cerrar, 5000)
   function cerrar() {
        clearInterval(vTemp)
    window.close()
     window.opener.document.getElementById("mensaje").style.color = "red"
    window.opener.document.getElementById("mensaje").innerHTML = "Tiempo agotado"
   }
   
   window.document.getElementById("enviar").addEventListener("click", enviar)
}

const enviar = () => {
 let mensajeRecibido = window.opener.document.getElementById("texto").value
 let mensajePadre = window.opener.document.getElementById("mensaje")

 mensajePadre.style.color = "blue"
 mensajePadre.innerHTML = `Recibido ${mensajeRecibido}`
 window.close()
}


window.document.addEventListener("DOMContentLoaded", inicio)
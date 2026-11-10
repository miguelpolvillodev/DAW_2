// Escribe aquí tu código
var vTemp;
var cont = 8;

const inicio = () => {
    let nombre = window.opener.nombre.value;
    let plan = window.opener.plan
  window.document.getElementById("datos").innerHTML = `Plan ${plan} para ${nombre}` 
   window.document.getElementById("confirmar").addEventListener("click", confirmar)

   window.document.getElementById("cuenta").innerHTML = `Quedan ${cont}` 

  vTemp = setInterval(cerrarVentana, 1000)
  function cerrarVentana() {
    
    if(cont == 0){
        clearInterval(vTemp)
        window.opener.document.getElementById("resultado").style.color = "red"
        window.opener.document.getElementById("resultado").innerHTML = "Tiempo agotado"
        window.close()
    }else{
    cont--;
    window.document.getElementById("cuenta").innerHTML = `Quedan ${cont}` 
    }
    
  }
}

const confirmar = () => {
  clearInterval(vTemp)
   window.opener.document.getElementById("resultado").style.color = "green"
        window.opener.document.getElementById("resultado").innerHTML = `Bienvenido: ${window.opener.nombre.value}!`
        window.close()
}

window.document.addEventListener("DOMContentLoaded", inicio)
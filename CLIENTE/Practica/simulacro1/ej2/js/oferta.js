// Escribe aquí tu código
var vTemp;
var cont = 10
const inicio = () => {
    window.document.getElementById("cuenta").innerHTML = `Quedan 10 segundos`
  vTemp = setInterval(cuentaAtras,1000)

  function cuentaAtras() {
    cont--
    let div = window.document.getElementById("cuenta")
    div.innerHTML = `Quedan ${cont} segundos`
    

    if(cont == 0){
        clearInterval(vTemp)
        window.close();
       let divP = window.opener.document.getElementById("estado")
       divP.style.color = "red"
       divP.innerHTML = "Oferta Caducada"
    }
  }

  window.document.getElementById("aceptar").addEventListener("click", aceptar)
}

const aceptar = () => {
     clearInterval(vTemp)
     window.close();
  let divP = window.opener.document.getElementById("estado")
       divP.style.color = "green"
       divP.innerHTML = "Oferta Aceptada"
}

window.document.addEventListener("DOMContentLoaded", inicio)
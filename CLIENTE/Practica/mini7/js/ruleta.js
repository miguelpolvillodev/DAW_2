// Escribe aquí tu código
var vTemp;

const inicio = () => {
 let divFecha = window.document.getElementById("fecha")
 let hoy = new Date()
 let dia = hoy.getDate()
 if(dia<10){
    dia = "0" + dia
 }
 let mes = hoy.getMonth() + 1
 if(mes<10){
    mes = "0" + mes
 }
 let año = hoy.getFullYear()

 divFecha.innerHTML = `Hoy es ${dia}/${mes}/${año}`

 window.document.getElementById("parar").disabled = true;

 window.document.getElementById("girar").addEventListener("click", girar)
 window.document.getElementById("parar").addEventListener("click", parar)
}

const girar = () => {
  window.document.getElementById("girar").disabled = true
  window.document.getElementById("parar").disabled = false

  vTemp = setInterval(mostrar, 100)
  function mostrar() {
    let num = ""
    for (let i = 0; i < 3; i++) {
        num += Math.floor(Math.random() * (3-0+1)) + 0
        
    }
    window.document.getElementById("numero").innerHTML = num
    window.document.getElementById("numero").value = num
  }


}

const parar = () => {
  clearInterval(vTemp)
  window.document.getElementById("girar").disabled = false
  let ganador = parseInt(window.document.getElementById("numero").value)
  let divRes = window.document.getElementById("resultado")
  if(ganador % 2 != 0){
    divRes.style.color = "red"
    divRes.innerHTML = "Impar"
    
  }
  if(ganador % 2 == 0){
divRes.style.color = "green"
    divRes.innerHTML = "Par"
  }
    
  
}

window.document.addEventListener("DOMContentLoaded", inicio)
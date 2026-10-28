// Escribe aquí tu código
var vTemp;
var v;
var cuenta;
var h1;

const inicio = () => {
  
    window.document.getElementById("empezar").addEventListener("click", abrirVentana)
    window.document.getElementById("cancelar").addEventListener("click", cancelar)
}

const abrirVentana = () => {
  clearInterval(vTemp)

  v = window.open("","","width=300px, height=150px")

 

   h1 = v.document.createElement("h1")
   v.document.body.appendChild(h1);
  cuenta = h1.innerHTML = "10"
  h1.setAttribute("id","cuenta")

 

  vTemp = setInterval(bajar,1000)




}

const cancelar = () => {
  v.close()
  clearInterval(vTemp)

  let div =  window.document.getElementById("fin")
  div.innerHTML =  `Cuenta cancelada`
  div.style.color="red"
}

const bajar = () => {
  if(cuenta>0){
    cuenta = Number(cuenta) - 1
    h1.innerHTML = `${cuenta}`
  }

  if (cuenta == 0) {
    clearInterval(vTemp)
    let ahora = new Date()
    let format = ahora.toLocaleTimeString();
  let div =  window.document.getElementById("fin")
  div.innerHTML =  `Cuenta terminada a las ${format}`
  div.style.color="blue"
    v.close()
  }
}

window.document.addEventListener("DOMContentLoaded", inicio)
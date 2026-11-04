// Escribe aquí tu código
var form;
const inicio = () => {
form = document.forms["pedido"]
form.elements["enviar"].addEventListener("click",enviar)
}

const enviar = () => {
    let div = window.document.getElementById("resumen")
  let nombre = form.elements["nombre"]
  let cantidad = form.elements["cantidad"]
  let talla = form.elements["talla"]
  let arrayPago = form.elements["pago"]

  let pago = "";

  for (let i = 0; i < arrayPago.length; i++) {
    if(arrayPago[i].checked){
       pago = arrayPago[i].value
    }
    
  }

  if(nombre.value == ""){
    div.style.color = "red"
    div.innerHTML = "Falta el nombre"
    
  }else if(cantidad.value == "" || isNaN(cantidad.value) || cantidad.value < 1){
    div.style.color = "red"
    div.innerHTML = "Cantidad no válida"
    
  }else if (talla.value == ""){
    div.style.color = "red"
    div.innerHTML = "Elige una talla"
    
  }else if (pago == ""){
div.style.color = "red"
    div.innerHTML = "Elige forma de pago"
    
  }else{
    div.style.color = "green"
    div.innerHTML = `Pedido de ${nombre.value}: ${cantidad.value} camisetas talla ${talla.value}, pago ${pago}.`

    nombre.value = ""
    nombre.focus()
    
  }
}



window.document.addEventListener("DOMContentLoaded", inicio)
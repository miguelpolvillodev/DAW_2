// Escribe aquí tu código
const inicio = () => {
  window.document.getElementById("calcular").addEventListener("click",calcular)
}


const calcular = () => {
  let arrayTamaño = window.document.getElementsByName("tamano")
  let cantidad = window.document.getElementById("cantidad")
  let ingredientesArray = window.document.getElementsByName("ingrediente")
  let div = window.document.getElementById("total")
  let tamaño = ""


  for (let i = 0; i < arrayTamaño.length; i++) {
    if(arrayTamaño[i].checked){
        tamaño = arrayTamaño[i].value
  }

  
}
if(tamaño == ""){
    div.style.color = "red"
    div.innerHTML ="Elige un tamaño"
  }

  if(cantidad.value == ""){
    div.style.color = "red"
    div.innerHTML ="Introduce cantidad"
  }

  let arraySeleccionados = []
  for (let i = 0; i < arrayIngredientes.length; i++) {
    if(arrayIngredientes[i].checked){
        arraySeleccionados.push(arrayIngredientes[i].value)
    }
    
  }

  if(arraySeleccionados == 0){
    arraySeleccionados = "Sin ingrendientes extra"
  }
let total = ${tamaño.value}
  div.innerHTML = `Pizzas: ${cantidad.value} de tamaño ${tamaño} con ${arraySeleccionados}`

}

window.document.addEventListener("DOMContentLoaded", inicio)
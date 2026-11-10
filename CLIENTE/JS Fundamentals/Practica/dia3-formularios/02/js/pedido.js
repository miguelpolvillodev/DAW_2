// Escribe aquí tu código
const inicio = () => {
  window.document.getElementById("calcular").addEventListener("click", calcular)
  window.document.getElementById("limpiar").addEventListener("click", limpiar)
}

const calcular = () => {
  let arrayTamaño = window.document.getElementsByName("tamano")
  let arrayIngredientes = window.document.getElementsByName("ingrediente")
  let cantidad = window.document.getElementById("cantidad").value
  let bebida = Number(window.document.getElementById("bebida").value)
  let div = window.document.getElementById("total")
  let tamaño = ""
  let seleccionados = []

  for (let i = 0; i < arrayTamaño.length; i++) {
    if (arrayTamaño[i].checked) {
      tamaño = arrayTamaño[i].value
    }
  }

  for (let i = 0; i < arrayIngredientes.length; i++) {
    if (arrayIngredientes[i].checked) {
      seleccionados.push(arrayIngredientes[i].value)
    }
  }

  if (tamaño == "") {
    div.style.color = "red"
    div.innerHTML = "Elige un tamaño"
  } else if (cantidad == "" || isNaN(cantidad) || cantidad % 1 != 0 || cantidad < 1) {
    div.style.color = "red"
    div.innerHTML = "La cantidad debe ser un número entero mayor que 0"
  } else {
    let nombreTamaño
    if (tamaño == "6") {
      nombreTamaño = "Pequeña"
    } else if (tamaño == "8") {
      nombreTamaño = "Mediana"
    } else {
      nombreTamaño = "Grande"
    }

    let ingredientes = "sin ingredientes extra"
    if (seleccionados.length > 0) {
      ingredientes = seleccionados.join(", ")
    }

    let total = (Number(tamaño) + seleccionados.length) * Number(cantidad) + bebida

    div.style.color = "green"
    div.innerHTML = `Pizzas: ${cantidad} de tamaño ${nombreTamaño} con ${ingredientes}<br>Total: ${total} €`
  }
}

const limpiar = () => {
  window.document.getElementById("pedido").reset()
  window.document.getElementById("total").innerHTML = ""
  window.document.getElementById("total").style.color = ""
}

window.document.addEventListener("DOMContentLoaded", inicio)

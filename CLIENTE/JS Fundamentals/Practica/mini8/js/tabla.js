

// Escribe aquí tu código
var prod = [
{id:1,nombre:"Pan",precio:2},
{id:2,nombre:"Leche",precio:3},
{id:3,nombre:"Queso",precio:8}
]
var numCheck = 0;
const inicio = () => {
 for (let i = 0; i < prod.length; i++) {
        rellenar(prod[i])
        
    }

    window.document.getElementById("borrar").addEventListener("click", borrarMarcados)
    window.document.getElementById("sumar").addEventListener("click", sumarMarcados)

    actualizarTotal()
}

const rellenar = (prod) => {
  let tr = document.createElement("tr")
  tr.id = prod.id
  
  let td1 = document.createElement("td")
  td1.innerHTML = prod.nombre
  let td2 = document.createElement("td")
  td2.innerHTML = prod.precio

  tr.appendChild(td1)
  tr.appendChild(td2)

  crearCheckbox(tr)
  window.document.getElementById("cuerpoTabla").appendChild(tr)
}

const crearCheckbox = (tr) => {
  numCheck++
  let td = document.createElement("td")
  let check = document.createElement("input")
  check.type = "checkbox"
  check.id = "check" + numCheck
  check.name = "marcar"

  td.appendChild(check)
  tr.appendChild(td)
}

const borrarMarcados = () => {
  let checks = document.getElementsByName("marcar")

   window.document.getElementById("error").style.color = ""
   window.document.getElementById("error").innerHTML = ""

  let marcada = false;
  for (let i = checks.length - 1; i >= 0 ; i--){
    if (checks[i].checked) {
        checks[i].parentNode.parentNode.remove()
        marcada = true;
    }
    actualizarTotal()
 }

 if(marcada == false){
    window.document.getElementById("error").style.color = "red"
    window.document.getElementById("error").innerHTML = "No hay nada marcado"

 }
}

const actualizarTotal = () => {
  var filas = document.getElementById("cuerpoTabla").getElementsByTagName("tr")
  let suma = 0
  for (let i = 0; i < filas.length; i++) {
    suma += Number(filas[i].children[1].innerHTML)
  }
  document.getElementById("total").innerHTML = `Total ${suma} euros`
}

const sumarMarcados = () => {
  let checks = document.getElementsByName("marcar")
   
   let suma = 0

  for (let i = checks.length - 1; i >= 0 ; i--){
    if (checks[i].checked) {
        var fila = checks[i].parentNode.parentNode
        suma += Number(fila.children[1].innerHTML)
        
    }
   window.document.getElementById("marcados").innerHTML = `Marcados: ${suma} euros`
 }
}

window.document.addEventListener("DOMContentLoaded", inicio)
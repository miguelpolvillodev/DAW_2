// Escribe aquí tu código (Ej1)
var arrayO = [
    {id:1,concepto:"Pan",categoria:"Comida",importe:2},
{id:2,concepto:"Cine",categoria:"Ocio",importe:9},
{id:3,concepto:"Luz",categoria:"Casa",importe:45},
{id:4,concepto:"Pizza",categoria:"Comida",importe:12}
  ]

var numCheck = 0;
var total = 0;
const inicio = () => {
  let hoy = new Date()
  let dia = hoy.getDate()
  let mes = hoy.getMonth() + 1
  let año = hoy.getFullYear()

  if(dia < 10){
    dia = "0" + dia
  }

  window.document.getElementById("fecha").innerHTML = `${dia}/${mes}/${año}`

  for (let i = 0; i < arrayO.length; i++) {
    crearFila(arrayO[i])
    
  }

  

  window.document.getElementById("add").addEventListener("click", añadirGasto)
  window.document.getElementById("borrar").addEventListener("click", borrarMarcados)

  window.document.getElementById("total").innerHTML = `Gastos: ${numCheck}. Total: ${total} euros`
}

const crearFila = (p) => {
  let tr = document.createElement("tr")
  tr.id = p.id;

  let td1 = document.createElement("td")
  td1.innerHTML = p.concepto
  let td2 = document.createElement("td")
  td2.innerHTML = p.categoria
  let td3 = document.createElement("td")
  td3.innerHTML = p.importe
  total += p.importe

  tr.appendChild(td1)
  tr.appendChild(td2)
  tr.appendChild(td3)

  crearCheckbox(tr)

  window.document.getElementById("cuerpoTabla").appendChild(tr)


}

const crearCheckbox = (tr) => {
  numCheck++;
  let td = document.createElement("td")
  let check = document.createElement("input")
  check.type = "checkbox"
  check.id = "checkbox" + numCheck;
  check.name = "marcar"
  td.appendChild(check)
  tr.appendChild(td)
}

const añadirGasto = () => {
    let div = window.document.getElementById("error")

    let concepto = window.document.getElementById("concepto")
    let categoria = window.document.getElementById("categoria")
    let importe = window.document.getElementById("importe")
    div.style.color = ""
    div.innerHTML = ""

  if(concepto.value == ""){
    div.style.color = "red"
    div.innerHTML = "Escribe un concepto"
  }else if(categoria.value == false){
    div.style.color = "red"
    div.innerHTML = "Elige una categoría"
  }else if(importe.value<0){
    div.style.color = "red"
    div.innerHTML = "El importe debe ser un número mayor que 0"
  }else{
    let nuevoP = {
        id: numCheck + 1,
        concepto:  concepto.value ,
        categoria: categoria.value,
        importe: importe.value
    }
    total += nuevoP.importe
    crearFila(nuevoP)
    concepto.value = ""
    categoria.value = ""
    importe.value = ""
    concepto.focus()
  }
}

const borrarMarcados = () => {
    window.document.getElementById("error").style.color = ""
    window.document.getElementById("error").innerHTML =""
  let checks = document.getElementsByName("marcar")
  let marcada = false

  for (let i = checks.length - 1; i >= 0; i--) {
    if(checks[i].checked){
        checks[i].parentNode.parentNode.remove()
        marcada = true
    }
    
  }

  if(marcada == false){
    window.document.getElementById("error").style.color = "red"
    window.document.getElementById("error").innerHTML ="No hay ningun gasto marcado"
  }
}

window.document.addEventListener("DOMContentLoaded", inicio)
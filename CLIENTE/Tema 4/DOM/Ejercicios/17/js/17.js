var tbody;
var tr;

const inicio = () => {

    window.document.getElementById("boton").addEventListener("click", añadirCol)
    window.document.getElementById("selec").addEventListener("click", selec)
    window.document.getElementById("deselec").addEventListener("click", deselect)
    window.document.getElementById("eliminar").addEventListener("click", eliminar)

    let Pro1 = {
    id: 1,
    nombre: "Pan",
    precio: 3,
    codigo:"A111"
}
   let Pro2 = {
    id: 2,
    nombre: "Agua",
    precio: 2,
    codigo:"A112"
}
   let Pro3 = {
    id: 3,
    nombre: "Carne",
    precio: 4,
    codigo:"A113"
}
   let Pro4 = {
    id: 4,
    nombre: "Azúcar",
    precio: 1,
    codigo:"A114"
}

  var arrayP = [Pro1,Pro2,Pro3,Pro4]
   tbody = document.getElementById("cuerpoTabla")
  
 
  
  

  for (let i = 0; i < arrayP.length; i++) {

    let prod = arrayP[i]
     tr = document.createElement("tr")
    tr.id = prod.id

     let td1 = document.createElement("td")
     let td2 = document.createElement("td")
     let td3 = document.createElement("td")

    td1.innerHTML = prod.nombre
    td2.innerHTML = prod.precio
    td3.innerHTML = prod.codigo

    tbody.appendChild(tr)
    tr.appendChild(td1)
    tr.appendChild(td2)
    tr.appendChild(td3)
    
  }
}

const añadirCol = () => {
let arrayF = tbody.getElementsByTagName("tr")

for (let i = 0; i < arrayF.length; i++) {
   let td = document.createElement("td")
   let inp = document.createElement("Input")
   inp.type = "checkbox"
   inp.id = "checkbox" + (i + 1)
   inp.name = "marcar"
   td.appendChild(inp)
   arrayF[i].appendChild(td)
    
}

}

const selec = () => {
  
  let checks = document.getElementsByName("marcar")
  for (let i = 0; i < checks.length; i++) {
    checks[i].checked = true
  }

}

const deselect = () => {
  let checks = document.getElementsByName("marcar")
  for (let i = 0; i < checks.length; i++) {
    checks[i].checked = false
  }
}

const eliminar = () => {
  let checks = document.getElementsByName("marcar")
  for (let i = checks.length - 1; i >= 0; i--) {
    if (checks[i].checked) {
      checks[i].parentNode.parentNode.remove()
    }
  }
}

window.document.addEventListener("DOMContentLoaded", inicio)
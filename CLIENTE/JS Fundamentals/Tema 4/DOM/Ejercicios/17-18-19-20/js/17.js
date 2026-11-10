var tbody;
var arrayP;

const inicio = () => {

    window.document.getElementById("boton").addEventListener("click", añadirCol)
    window.document.getElementById("selec").addEventListener("click", selec)
    window.document.getElementById("deselec").addEventListener("click", deselect)
    window.document.getElementById("eliminar").addEventListener("click", eliminar)
    window.document.getElementById("add").addEventListener("click", añadirProd)
  

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

   arrayP = [Pro1,Pro2,Pro3,Pro4]
   tbody = document.getElementById("cuerpoTabla")
  
 
  
  

  for (let i = 0; i < arrayP.length; i++) {

    let prod = arrayP[i]
    let tr = document.createElement("tr")
     

     tr.addEventListener("mouseover", () => {
       tr.style.backgroundColor = "yellow"
     });

     tr.addEventListener("mouseout", () => {
       tr.style.backgroundColor = ""
     })
    tr.id = prod.id

     let td1 = document.createElement("td")
     let td2 = document.createElement("td")
     let td3 = document.createElement("td")

    
    td2.innerHTML = prod.precio
    td3.innerHTML = prod.codigo

    let enlaceNombre = document.createElement("a")
    enlaceNombre.href ="#"
    enlaceNombre.innerHTML = prod.nombre
    td1.appendChild(enlaceNombre)

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
   let inp = document.createElement("input")
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

const añadirProd = () => {

  let arrayTd = window.document.getElementsByTagName("tr")

  let iNombre = window.document.getElementById("nombreN")
  let iPrecio = window.document.getElementById("precioN")
  let iCodigo = window.document.getElementById("codigoN")

    
 

  let prodN = {
    id: arrayTd.length,
    nombre: iNombre.value ,
    precio: iPrecio.value,
    codigo: iCodigo.value

  }

  arrayP.push(prodN);

  

    let prodI = arrayP[arrayP.length -1 ]
    let tr = document.createElement("tr")
     tr.addEventListener("mouseover", () => {
       tr.style.backgroundColor = "yellow"
     });

     tr.addEventListener("mouseout", () => {
       tr.style.backgroundColor = ""
     })
    tr.id = prodI.id

     let td1 = document.createElement("td")
     let td2 = document.createElement("td")
     let td3 = document.createElement("td")

    td1.innerHTML = prodI.nombre
    td2.innerHTML = prodI.precio
    td3.innerHTML = prodI.codigo

    tbody.appendChild(tr)
    tr.appendChild(td1)
    tr.appendChild(td2)
    tr.appendChild(td3)
    
  
}


window.document.addEventListener("DOMContentLoaded", inicio)
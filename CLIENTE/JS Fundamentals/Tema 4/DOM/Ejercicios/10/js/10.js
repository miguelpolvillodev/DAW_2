inicio = () => {
  window.document.getElementById("boton").addEventListener("click", generarLi)
}

generarLi = () => {
    
   let nuevoLi = document.createElement("li")
    nuevoLi.innerHTML = "elemento nuevo"
    /* 
    let body = document.body
    let lista2 = body.firstElementChild
   lista2.appendChild(nuevoLi)
   */ 
    let lista = window.document.getElementById("lista")
    lista.appendChild(nuevoLi)
   
}


window.document.addEventListener("DOMContentLoaded", inicio)


// Escribe aquí tu código
const inicio = () => {
  
    document.getElementById("anadir").addEventListener("click", lista)
}

const lista = () => {
    let input = window.document.getElementById("tarea")

  if(input.value == ""){
    alert("Escribe una tarea")
  }else{
    let lista = window.document.getElementById("lista")
    let li = document.createElement("li")
    li.innerHTML = input.value
    lista.appendChild(li)

    let cerrar = document.createElement("button")
    cerrar.innerHTML = "X"

    cerrar.addEventListener("click",() => {
      li.remove()
    })
 li.appendChild(cerrar)
 input.value = ""
      input.focus()
  }
}



window.document.addEventListener("DOMContentLoaded", inicio)

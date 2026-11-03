// Escribe aquí tu código
const inicio = () => {
  window.document.getElementById("reservar").addEventListener("click", reservar)
}


const reservar = () => {
  let nombre = window.document.getElementById("nombre")
  let entradas = window.document.getElementById("entradas")
  let arrayTipos = window.document.getElementsByName("tipo")
  let div = window.document.getElementById("resultado")
  let avisar = window.document.getElementById("newsletter")

  let selec;

  for (let i = 0; i < arrayTipos.length; i++) {
    if (arrayTipos[i].checked) {
        selec = arrayTipos[i].value
    }
    
  }

  if (nombre.value == "") {
    div.style.color = "red"
    div.innerHTML = "Escribe tu nombre"
  }else if (isNaN(entradas.value) || entradas.value < 1 || entradas.value > 10){
    div.style.color = "red"
    div.innerHTML = "Entradas: de 1 a 10"
  }else if (selec == undefined){
    div.style.color = "red"
    div.innerHTML = "Elige un tipo de entrada"
  }else{
    let total = 0;
    if(selec == "general"){
        total = (20 * entradas.value)
    }else{
        total = (35 * entradas.value)
    }
    
    div.style.color = "green"
    div.innerHTML = `Reserva de ${nombre.value}: ${entradas.value} entradas ${selec}. Total: ${total} euros.`

    if(avisar.checked){
        div.innerHTML += `Te avisaremos`
    }


    let ul = window.document.getElementById("historial")
    let li = window.document.createElement("li")
    ul.appendChild(li)
    li.innerHTML = `${nombre.value}: ${entradas.value} entradas`
    li.addEventListener("click", () => {
      
      li.remove()
    })

    nombre.value = ""
      entradas.value = ""

  }
}


window.document.addEventListener("DOMContentLoaded", inicio)

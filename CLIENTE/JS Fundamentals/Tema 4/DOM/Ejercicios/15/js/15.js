const inicio = () => {
  
  let primerP =  document.body.firstElementChild
  let segundoP = primerP.nextElementSibling
  let terceroP = segundoP.nextElementSibling
  terceroP.style.backgroundColor = "red"
}

window.document.addEventListener("DOMContentLoaded", inicio)
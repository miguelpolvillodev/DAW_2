// Escribe aquí tu código


const inicio = () => {
  window.document.getElementById("color").addEventListener("change", colorPagina)
  window.document.getElementById("negrita").addEventListener("change", negrita)
  window.document.getElementById("resumenBtn").addEventListener("click", resumen)
}

const resumen = () => {
  let select = document.getElementById("color")
  let texto = select.options[select.selectedIndex].text
  let valor;
  if (document.getElementById("negrita").checked) {
    valor = "sí"
  } else {
    valor = "no"
  }
  document.getElementById("resumen").innerHTML = `Color: ${texto}. Negrita: ${valor}`
}

const negrita = () => {

   let check = window.document.getElementById("negrita")
    let parrafo = window.document.getElementById("parrafo")
  
if (check.checked) {
    parrafo.style.fontWeight = "bold"
}else{
    parrafo.style.fontWeight = "normal"
}
}

const colorPagina = () => {
 let  color = document.getElementById("color").value
  document.body.style.backgroundColor = color
}

window.document.addEventListener("DOMContentLoaded", inicio)
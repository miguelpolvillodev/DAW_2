// Escribe aquí tu código (principal)
const inicio = () => {
  window.document.getElementById("abrir").addEventListener("click", abrirHija)
}

const abrirHija = () => {
  let texto = window.document.getElementById("texto")

  if(texto.value == ""){
    window.document.getElementById("mensaje").innerHTML = "Escribe algo"
  }else{
    let v = window.open("hija.html","","width=300px, height=200px")
  }
}
window.document.addEventListener("DOMContentLoaded", inicio)
// Escribe aquí tu código
const inicio = () => {
  window.document.getElementById("caja").addEventListener("mouseover", cambiaFondo)
  window.document.getElementById("caja").addEventListener("mouseout", cambiaFondo2)
  window.document.getElementById("nombre").addEventListener("blur", mayus)
   window.document.getElementById("texto").addEventListener("keyup", caracteres)

}

const caracteres = () => {
let cont = 0
  let texto = window.document.getElementById("texto")

   document.getElementById("contador").innerHTML = `${texto.value.length} caracteres`
}

const mayus = () => {
 let nombre = window.document.getElementById("nombre")

nombre.value = nombre.value.toUpperCase()


}

const cambiaFondo = () => {
  window.document.getElementById("caja").style.backgroundColor= "yellow"
}
const cambiaFondo2 = () => {
  window.document.getElementById("caja").style.backgroundColor= ""
}
window.document.addEventListener("DOMContentLoaded", inicio)

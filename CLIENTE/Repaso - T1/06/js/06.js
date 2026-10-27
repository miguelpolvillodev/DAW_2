var v;
var segundos = 0
var reales = 0

const inicio = () => {
    document.getElementById("boton").addEventListener("click", () => {
    segundos = Number(document.getElementById("segundos").value) * 1000
    reales = document.getElementById("segundos").value
    setTimeout(abrir, segundos)

   
  })
} 


const abrir = () => {
      v = window.open("nueva.html","","width=300px, height=300px")
      v.document.write(`<h1>Han pasado ${reales} segundos</h1>`)
      setTimeout(cerrar,10000)
    } 

const cerrar = () => {
  v.close()
  document.getElementById("segundos").value = "Has cerrado la ventana porque han pasado 10 segundos"; 
}




window.document.addEventListener("DOMContentLoaded", inicio)
const cargarPagina = () => {
  document.getElementById("pagPrincipal").addEventListener("click",resultado)
}


const resultado = () => {
let nombre = document.getElementById("name").value
let apellidos = document.getElementById("apellidos").value
let fecha = document.getElementById("fecha").value

let hoy = new Date().getFullYear();
let añoIntro = new Date(fecha).getFullYear();
let bisiesto = 0;

for (let i = añoIntro; i <= hoy; i++) {
   if ((i % 4 == 0 && i % 100 !== 0) || i % 400 === 0){
    bisiesto++
   }
}

window.opener.document.getElementById("resultado").innerHTML += `Nombre: ${nombre} <br>
                                                                Apellidos: ${apellidos} <br>
                                                                Fecha Nacimiento ${fecha} <br>
                                                                Años bisiestos que han pasado: ${bisiesto} `
window.close();
}

window.addEventListener("DOMContentLoaded",cargarPagina)
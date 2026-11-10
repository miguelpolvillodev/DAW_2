var vTemp;
var tiempoS = 0;

const inicio = () => {
  window.document.getElementById("ini").addEventListener("click", iniciar);
  window.document.getElementById("parar").addEventListener("click", parar);
  window.document.getElementById("resumen").addEventListener("click",ventanaNueva)
};

const ventanaNueva = () => {
  let v = window.open("resumen.html","","width=500px, height=500px") 
}

const iniciar = () => {
  clearInterval(vTemp);           
  vTemp = setInterval(generar, 1000);
};

const generar = () => {
  let min = Number(window.document.getElementById("min").value);
  let max = Number(window.document.getElementById("max").value);
  let aleatorio = Math.floor(Math.random() * (max - min + 1)) + min;
  window.document.getElementById("res").value = aleatorio;
  tiempoS ++;
};

const parar = () => {
  clearInterval(vTemp);
};

window.document.addEventListener("DOMContentLoaded", inicio);

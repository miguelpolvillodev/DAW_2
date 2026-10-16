var temp;
var intervalo;
var inicial;

cargarPagina = () => {
inicial = Number(document.getElementById("temporizador").innerHTML);
document.getElementById("iniciar").addEventListener("click",iniciar);
document.getElementById("pausar").addEventListener("click", pausar);
document.getElementById("reiniciar").addEventListener("click", reinicio);
}

const cuenta = () => {
const campo = document.getElementById("temporizador")
const temp = Number(campo.innerHTML) - 1
campo.innerHTML = temp;
if (temp<=0){
    pausar();
}
}

const iniciar = () => {
    const temp = Number(document.getElementById("temporizador").innerHTML);
    if(intervalo == null && temp > 0){
intervalo = setInterval(cuenta,1000)
    }
  
}

const pausar = () => {
  clearInterval(intervalo);
  intervalo = null;
}

const reinicio = () => {
  pausar();
  document.getElementById("temporizador").innerHTML = inicial;
}







window.addEventListener("DOMContentLoaded", cargarPagina);
var div;
var vTemp;
var cont = 0;                       // cuenta las vueltas para alternar sin leer colores

const inicio = () => {
  div = document.getElementById("contenedor");
  vTemp = setInterval(cambia, 1000);
  setTimeout(terminar, 5000);       // a los 5 segundos
};

const cambia = () => {
  if (cont % 2 == 0) {
    div.style.backgroundColor = "green";
    div.innerHTML = "Betis";
  } else {
    div.style.backgroundColor = "red";
    div.innerHTML = "Sevilla";
  }
  cont++;
};

const terminar = () => {
  clearInterval(vTemp);
  div.style.display = "none";       // desaparece
  window.location.href = "ppal.html";   // redirige
};

window.addEventListener("DOMContentLoaded", inicio);
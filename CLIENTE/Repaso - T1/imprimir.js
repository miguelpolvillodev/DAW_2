//TEMPORIZADOR parar con boton
const arrayR = ["El que la sigue la consigue", "Más vale prevenir que curar", "Quien todo lo quiere, todo lo pierde",
"No por mucho madrugar amanece más temprano", "Persona prevenida vale por dos"];

var vTemp;      // global, para que lo vea parar()
var cont = 0;   // global, posición de la frase que toca mostrar

function inicio() {
  vTemp = setInterval(f1, 2000);
  document.getElementById("boton").addEventListener("click", parar);
}

function f1() {
  document.getElementById("resultado").innerHTML = arrayR[cont];
  cont++;
  if (cont == arrayR.length) {
    cont = 0;       // si pasa de la última, vuelve a la primera
  }
}

function parar() {
  clearInterval(vTemp);
  document.getElementById("boton").style.backgroundColor = "red";
}

document.addEventListener("DOMContentLoaded", inicio);
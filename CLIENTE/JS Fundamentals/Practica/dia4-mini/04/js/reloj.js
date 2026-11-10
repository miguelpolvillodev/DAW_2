// Escribe aquí tu código
var vReloj;

const inicio = () => {
  actualizarReloj(); 
  vReloj = setInterval(actualizarReloj, 1000);
  document.getElementById("parar").addEventListener("click", pararReloj);
  document.getElementById("reanudar").addEventListener("click", reanudarReloj);

}

const actualizarReloj = () => {
 const ahora = new Date(); 
 let h =  ahora.getHours();
 let m =  ahora.getMinutes();
 let s =  ahora.getSeconds();
 if (h < 10) { h = "0" + h; } 
 if (m < 10) { m = "0" + m; }
 if (s < 10) { s = "0" + s; }
 document.getElementById("hora").value = `${h}:${m}:${s}`;
};
const pararReloj = () => {
 clearInterval(vReloj);
}

const reanudarReloj = () => {
clearInterval(vReloj);
 vReloj = setInterval(actualizarReloj, 1000);
}



window.document.addEventListener("DOMContentLoaded", inicio)

var tiempoMs;
var restantes;
var intervalo;

tiempoMs = window.opener.document.getElementById("segundos").value;
restantes = tiempoMs;

intervalo = setInterval(f1, 1000);

function f1() {
  restantes--;

  if (restantes <= 0) {
    clearInterval(intervalo);
    window.close();
    window.opener.document.getElementById("resultado").innerHTML =
      `Ya han pasado ${tiempoMs} segundos y se ha cerrado la ventana emergente`;
  } else {
    window.document.body.innerHTML = `<p>Cuenta atrás: ${restantes}</p>`;
  }
}

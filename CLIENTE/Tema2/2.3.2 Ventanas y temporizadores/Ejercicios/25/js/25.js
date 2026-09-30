var nuevaVentana;
var tiempoMs;
var restantes;
var intervalo;

function abrirVentana() {
  tiempoMs = document.getElementById("segundos").value;
  restantes = tiempoMs;
  nuevaVentana = window.open(
    "25-emergente.html",
    "",
    "width=300px, height=300px",
  );
  intervalo = setInterval(tick, 1000);
}

function tick() {
  restantes--;

  if (restantes <= 0) {
    clearInterval(intervalo);
    nuevaVentana.close();
    document.getElementById("resultado").innerHTML =
      `Ya han pasado ${total} segundos y se ha cerrado la ventana emergente`;
  } else {
    nuevaVentana.document.body.innerHTML = `<p>Cuenta atrás: ${restantes}</p>`;
  }
}

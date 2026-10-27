const f1 = () => {
  const ahora = new Date();

  let hora = 23 - ahora.getHours();
  let minutos = 59 - ahora.getMinutes();
  let segundos = 59 - ahora.getSeconds();

  if (hora < 10) {
    hora = "0" + hora;
  }

  if (minutos < 10) {
    minutos = "0" + minutos;
  }

  if (segundos < 10) {
    segundos = "0" + segundos;
  }

  document.getElementById("tiempo").value = `${hora}:${minutos}:${segundos}`;
};

inicio = () => {
  f1();
  setInterval(f1, 1000);
};
window.document.addEventListener("DOMContentLoaded", inicio);

var cont = parseInt(prompt("Introduce numero de segundos"));
function abrirVentana(cont) {
  let nuevaVentana = window.open(
    "23-segunda.html",
    "",
    "width= 400, height=300",
  );

  let temp1 = setInterval(cerrar, 1000);

  function cerrar() {
    if (cont == 0) {
      nuevaVentana.close();
      clearInterval(temp1);
    } else {
      cont--;
      nuevaVentana.document.body.innerHTML = `<p>Cuenta atras: ${cont}</p>`;
    }
  }
}

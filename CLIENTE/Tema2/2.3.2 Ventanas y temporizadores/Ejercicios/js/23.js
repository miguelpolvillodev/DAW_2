function abrirVentana() {
  let nuevaVentana = window.open(
    "23-segunda.html",
    "",
    "width= 400, height=300",
  );

  let temp1 = setInterval(cerrar, 1000);

  var cont = 10;

  function cerrar() {
    if (cont == 0) {
      nuevaVentana.close();
    } else {
      nuevaVentana.document.body.innerHTML = `<p>Cuenta atras: ${(cont = cont - 1)}</p>`;
    }
  }
}

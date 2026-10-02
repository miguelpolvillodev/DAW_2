
function abrirVentana() {
  let cont = parseInt(document.getElementById("segundos").value);
  let nuevaVentana = window.open(
    "24-segunda.html",
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
      //nuevaVentana.document.body.innerHTML = `<p>Cuenta atras: ${cont}</p>`;
      nuevaVentana.document.getElementById("contador").innerHTML = `${cont}`
    }
  }
}

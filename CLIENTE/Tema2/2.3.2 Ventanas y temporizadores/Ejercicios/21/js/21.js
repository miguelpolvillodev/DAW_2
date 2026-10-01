var ventana1;
var ventana2;

function abrirVentanas() {
  ventana1 = window.open(
    "21-primera.html",
    "v1",
    "width=300,height=200,top= 100,left=300",
  );

  ventana2 = window.open(
    "21-segunda.html",
    "v2",
    "width=300,height=200,top= 500,left=300",
  );

  // ventana1.ventana2 = ventana2;
  //ventana2.ventana1 = ventana1;
}

function cerrarVentanas() {
  ventana1.window.close();
  ventana2.window.close();
}

function cambiarFondo1() {
  ventana1.focus();
  ventana2.focus();
  ventana1.document.body.style.backgroundColor = "#FFECA1";
}

function cambiarFondo2() {
  ventana2.focus();
  ventana1.focus();
  ventana2.document.body.style.backgroundColor = "#EFC3CA";
}

function enviarMensaje2() {
  window.opener.ventana2.document.body.innerHTML += "La ventana 1 te saluda";
}

function cambiaColor2() {
  window.opener.ventana2.document.body.style.backgroundColor = " #7DDA58";
}
function enviarMensaje1() {
  window.opener.ventana1.document.body.innerHTML += "La ventana 2 te saluda";
}

function cambiaColor1() {
  window.opener.ventana1.document.body.style.backgroundColor = " #5DE2E7";
}

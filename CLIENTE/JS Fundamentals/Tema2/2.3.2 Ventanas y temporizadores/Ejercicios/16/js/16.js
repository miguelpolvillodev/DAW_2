var b1;
function abrirBoton() {
  b1 = window.open(
    "16-segunda.html",
    "b1",
    "width=300, height=400,top=400,left=400",
  );
  b1.focus();
}

function mover() {
  b1.moveBy(200, 300);
  b1.focus();
}

function mover2() {
  b1.moveTo(500, 200);
  b1.focus();
}

function aumentar() {
  b1.resizeBy(100, 100);
  b1.focus();
}

function tamaño() {
  b1.resizeTo(100, 150);
  b1.focus();
}

function colorSecundaria() {
  document.body.style.backgroundColor = "green";
}

function colorPrimaria() {
  window.opener.document.body.style.backgroundColor = "red";
}

function closeSegunda() {
  window.close();
}

function closeAll() {
  closeSegunda();
  window.opener.close();
}

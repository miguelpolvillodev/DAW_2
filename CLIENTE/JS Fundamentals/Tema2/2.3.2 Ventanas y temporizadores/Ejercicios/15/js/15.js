let decision = confirm("Aceptas abrir una ventana?");

if (decision == true) {
  let nuevaVentana = window.open(
    "",
    "",
    "toolbar=0,location=0,menubar=0,resizable=1,scrollbars=1,width=200px,height=80px,top=500px,left=500px",
  );
  nuevaVentana.document.write("<h1>Entorno Cliente</h1>");
}

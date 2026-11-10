var ventanaNueva;

function abrirVentana() {
  ventanaNueva = window.open(
    "17-selector_color.html",
    "",
    "width=300px, height=400px",
  );
}

let color = prompt("Dime un color");
window.opener.document.body.style.backgroundColor = `${color}`;
window.close();

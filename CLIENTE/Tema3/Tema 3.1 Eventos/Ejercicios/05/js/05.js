cargarPagina = () => {
  for (let i = 0; i <= 9; i++) {
    document.getElementById(i).addEventListener("click", () => mostrarValue(i));
  }
};

mostrarValue = (i) => {
  let valor = document.getElementById(i).value;
  document.getElementById("valor").innerHTML = `<div>${valor}</div>`;
};

window.addEventListener("DOMContentLoaded", cargarPagina);
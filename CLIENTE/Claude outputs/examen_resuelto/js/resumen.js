// Ventana hija: lee los datos de la ventana padre con window.opener
function inicio() {
  let padre = window.opener;
  let lista = padre.alumnos;                                      // el array global del padre

  let nombres = lista.map(a => a.nombre).join(", ");              // map + join
  let mayores = lista.filter(a => a.edad >= 18).length;           // filter

  document.getElementById("capa").innerHTML = `
    <p>Nº de alumnos: ${lista.length}</p>
    <p>Mayores de edad: ${mayores}</p>
    <p>Nombres: ${nombres}</p>`;
}

document.addEventListener("DOMContentLoaded", inicio);

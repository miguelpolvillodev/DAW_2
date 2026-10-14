cargarPagina = () => {
  document.getElementById("validar").addEventListener("click", validacion);
};

validacion = (e) => {
  const nombre = document.getElementById("Nombre").value.trim().toLowerCase();
  const apellido = document.getElementById("Apellidos").value.trim().split(" ");
  const errorN = document.getElementById("errorNombre");
  const errorA = document.getElementById("errorApellido");
  const f1 = document.getElementById("f1");
  let validar = true;

  if (
    nombre.toLowerCase().startsWith("a") ||
    nombre.toLowerCase().startsWith("e") ||
    nombre.toLowerCase().startsWith("i") ||
    nombre.toLowerCase().startsWith("o") ||
    nombre.toLowerCase().startsWith("u")
  ) {
    errorN.innerHTML = "";
  } else {
    errorN.style.color = "red";
    errorN.innerHTML = `No cumple la validación`;
    validar = false;
  }

  if (apellido.length >= 2) {
    errorA.innerHTML = "";
  } else {
    errorA.style.color = "red";
    errorA.innerHTML =
      `No cumple la validación`;
    validar = false;
  }

  if (validar) {
    alert("entra");
    f1.action = "https://www.ceu.es";
    f1.submit();
  }
};

window.addEventListener("DOMContentLoaded", cargarPagina);

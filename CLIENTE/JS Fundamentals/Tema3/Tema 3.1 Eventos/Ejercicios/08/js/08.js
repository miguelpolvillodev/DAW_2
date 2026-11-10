

const cargarPagina = () => {
  document.getElementById("enviar").addEventListener("click", validacion);
};
  
const validacion = (e) => {
  e.preventDefault();
  const f1 = document.getElementById("formulario");
  const nombre = document.getElementById("nombre").value.trim();
  const apellidos = document.getElementById("apellidos").value.trim();
  const edad = document.getElementById("edad").value.trim();
  const provincia = document.getElementById("provincia").value;
  const resultado = document.getElementById("resultado");

  let error = "";

  if (nombre === "") {
    error = "El nombre no puede estar en blanco";
  } else if (apellidos === "") {
    error = "Los apellidos no pueden estar en blanco";
  } else if (edad === "") {
    error = "La edad no puede estar en blanco";
  } else if (isNaN(edad) || edad < 0 || edad > 105) {
    error = "La edad debe ser un número entre 0 y 105";
  } else if (provincia === "0") {
    error = "Debes seleccionar una provincia";
  }

  if (error !== "") {
    resultado.style.color = "red";
    resultado.innerHTML = error;
    return;
  }

  resultado.innerHTML = "";
  if (confirm("¿Desea enviar el formulario?")) {
    f1.submit();
  }
};

window.addEventListener("DOMContentLoaded", cargarPagina);
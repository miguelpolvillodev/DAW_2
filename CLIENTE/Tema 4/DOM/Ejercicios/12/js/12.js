const inicio = () => {
  for (let i = 1; i <= 3; i++) {
    document.getElementById("enlace_" + i).addEventListener("click", (e) => {
      e.preventDefault();
      alternar(i);
    });
  }
};

const alternar = (i) => {
  const parrafo = document.getElementById("contenidos_" + i);
  const enlace = document.getElementById("enlace_" + i);
  if (parrafo.style.display == "none") {
    parrafo.style.display = "block";
    enlace.innerHTML = "Ocultar Contenido";
  } else {
    parrafo.style.display = "none";
    enlace.innerHTML = "Mostrar Contenido";
  }
};
window.addEventListener("DOMContentLoaded", inicio);

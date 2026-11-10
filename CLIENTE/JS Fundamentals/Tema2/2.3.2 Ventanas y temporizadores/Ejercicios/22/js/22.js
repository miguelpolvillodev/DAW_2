function crearCuadrados() {
  for (let i = 0; i <= 2000; i++) {
    let cuadrado = document.createElement("div");
    cuadrado.style.width = "50px";
    cuadrado.style.height = "50px";
    cuadrado.style.backgroundColor = `rgb(
  ${Math.floor(Math.random() * 256)},
  ${Math.floor(Math.random() * 256)},
  ${Math.floor(Math.random() * 256)}
)`;
    cuadrado.style.position = "absolute";
    cuadrado.style.left = `${Math.floor(Math.random() * (950 - 0 + 1)) + 0}px`;
    cuadrado.style.top = `${Math.floor(Math.random() * (750 - 0 + 1)) + 0}px`;
    document.body.appendChild(cuadrado);
  }
}

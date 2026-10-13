var total;
cargarPagina = () => {
  total = Number(document.getElementById("valor").innerHTML)
  document.getElementById("sumar").addEventListener("click",sumar)
  document.getElementById("restar").addEventListener("click",restar)
}

mensaje = () => {
  if (total == 3) {
    valor.innerHTML += ` Alcanzado el valor 3`
  }
}
sumar = () => {
total++;
valor.innerHTML = total;
mensaje()
}

restar = () => {
total--;
valor.innerHTML = total;
mensaje()
}
window.addEventListener("DOMContentLoaded",cargarPagina);
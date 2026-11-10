var vHora
var cont = 0

const inicio = () => {
  document.getElementById("iniciar").addEventListener("click", iniciar)
  document.getElementById("pausar").addEventListener("click", pausar)
  document.getElementById("reiniciar").addEventListener("click", reiniciar)
}

const iniciar = () => {
  clearInterval(vHora)                // no duplicar
  vHora = setInterval(contar, 1000)   // solo arranca
}

const contar = () => {                // esto pasa cada segundo
  cont++
  mostrar()
  if (cont == 20) {
    document.body.style.backgroundColor = "red"
    clearInterval(vHora)
  }
}

const mostrar = () => {
  let m = Math.floor(cont / 60)
  let s = cont % 60
  if (m < 10) { m = "0" + m }
  if (s < 10) { s = "0" + s }
  document.getElementById("tiempo").value = `${m}:${s}`
}

const pausar = () => {
  clearInterval(vHora)
}

const reiniciar = () => {
  clearInterval(vHora)
  cont = 0
  mostrar()
  document.body.style.backgroundColor = ""
}

window.addEventListener("DOMContentLoaded", inicio)


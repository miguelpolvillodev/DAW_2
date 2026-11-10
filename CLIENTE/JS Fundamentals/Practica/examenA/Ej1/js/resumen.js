const inicio = () => {
  let ganador = window.opener.document.getElementById("numero")

  window.document.getElementById("texto").innerHTML += `${ganador.value}`

  window.document.getElementById("cerrar").addEventListener("click", cerrar)
}


const cerrar = () => {
  let boletosIntroducidos = window.document.getElementById("boletos")
  let total = boletosIntroducidos.value * 6000

  window.opener.document.getElementById("ganancia").innerHTML = `Ha ganado ${total} euros`
  window.close()
}
window.document.addEventListener("DOMContentLoaded", inicio)
const inicio = () => {
  let min = window.opener.document.getElementById("min").value
  let max = window.opener.document.getElementById("max").value
  let res = window.opener.document.getElementById("res").value
  let tiempo = window.opener.tiempoS
  document.getElementById("resumenSecundaria").innerHTML = `Valor mínimo:${min} \n
Valor máximo:${max} \n
Número lotería seleccionado: ${res} \n
Han pasado:  ${tiempo} segundos`
  document.getElementById("cerrar").addEventListener("click", () => {
    window.close()
  })
}
window.addEventListener("DOMContentLoaded", inicio)


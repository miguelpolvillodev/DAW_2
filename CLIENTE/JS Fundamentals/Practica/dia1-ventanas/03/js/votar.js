// Escribe aquí tu código

const inicio = () => {

  window.document.getElementById("enviar").addEventListener("click", validar)
}

const validar = () => {
  let radios = document.getElementsByName("equipo")
  let encontrada;

  for (let i = 0; i < radios.length; i++) {
    if(radios[i].checked){
        encontrada = radios[i]
        window.opener.clearTimeout(window.opener.vTemp);
      
    }
  }

  if (encontrada != undefined) {
     window.opener.res.innerHTML = `Has votado: ${encontrada.value}`
     window.close()
  } else {
    alert("Selecciona un equipo")
  }
}

window.document.addEventListener("DOMContentLoaded", inicio)
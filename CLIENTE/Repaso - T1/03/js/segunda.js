inicio = () => {
  window.document.getElementById("boton").addEventListener("click", comprobar)
}




comprobar = () => {
  let text = document.getElementById("texto").value

  if(text == ""){
    alert("texto vacio")
  }else{
    window.opener.document.getElementById("mensaje").innerHTML = text
    window.close()
  }
}





window.document.addEventListener("DOMContentLoaded", inicio)
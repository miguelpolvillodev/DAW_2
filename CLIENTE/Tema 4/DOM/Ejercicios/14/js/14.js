inicio = () => {
  window.document.getElementById("boton").addEventListener("click", pregunta)
}

const pregunta = () => {
  let texto = prompt("Introduce texto")
  let num = Number(prompt("Introduce numero del 1 al 10"))
  if(num>10 || num<0){
    alert("Numero incorrecto fuera de rango")
  }

  let arrayLi = document.getElementsByTagName("li");
  alert(arrayLi)
 
  for (let i = 0; i < arrayLi.length; i++) {
    if(num== i){
        arrayLi[i].innerHTML = texto
    }
    
  }
}
window.document.addEventListener("DOMContentLoaded", inicio)
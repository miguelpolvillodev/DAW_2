inicioPag = () => {
  window.document.getElementById("boton").addEventListener("click", comprobarEdad);
}

comprobarEdad = () => {
  const edad = Number(window.document.getElementById("edad").value);
  const res = window.document.getElementById("resultado");
  
  if(isNaN(edad)){
    res.innerHTML = `Error, introduce un numero`;
    //res.style.color = "red";
    res.className = "rojo"
  }


if (edad >= 18) {
   res.innerHTML = `Eres mayor de edad`
   //res.style.color = "green";
   res.className = "verde";
}
    
if (edad < 18) {
   res.innerHTML = `Eres menor de edad`
  // res.style.color = "red"
  res.classList.remove("verde")
  res.className = "rojo"
}

  
}

window.document.addEventListener("DOMContentLoaded", inicioPag);
var conteo = 0;
cargarPagina = () => {
  document.getElementById("check1").addEventListener("click",contarChecks)
  document.getElementById("check2").addEventListener("click",contarChecks)
  document.getElementById("check3").addEventListener("click",contarChecks)
  document.getElementById("check4").addEventListener("click",contarChecks)
  document.getElementById("check5").addEventListener("click",contarChecks)
  document.getElementById("check6").addEventListener("click",contarChecks)
  document.getElementById("validar").addEventListener("click",check)
  
}

contarChecks = () => {
conteo++;  
}

check = (e) => {
e.preventDefault();
  if (conteo>=3) {
    alert(`Hay mas de 3 checkboxs marcados`)
  }else{
    alert(`Error no hay mas de ${conteo} checkbox marcados`)
  }
}

window.addEventListener("DOMContentLoaded",cargarPagina);
iniciarPag = () => {
  
  window.document.getElementById("boton").addEventListener("click",selectOp);
}

selectOp = () => {
let miFormulario = document.getElementById("miForm");
const arrayRa =  miFormulario.getElementsByTagName("input")

  for (let i = 0; i < arrayRa.length; i++) {
    const pos = arrayRa[i]

    if(pos.checked){
        alert(`La posicion ${pos.value} ha sido seleccionada`)
    }
    
  }
}



window.document.addEventListener("DOMContentLoaded", iniciarPag);
iniciarPag = () => {
  window.document.getElementById("validar").addEventListener("click", validar);
  window.document.getElementById("boton1").addEventListener("click", marcar);
  window.document.getElementById("boton2").addEventListener("click", desmarcar);
}

validar = () => {
  let form = window.document.getElementById("miForm");
  const arrayCh =  form.getElementsByTagName("input");

  let chekeados = 0;

  for (let i = 0; i < arrayCh.length; i++) {
    if (arrayCh[i].checked){
        chekeados++;
    }
    
  }

  if(chekeados >= 3){
    alert("Hay más de 3 checks marcados")
  }else{
    alert("NO Hay más de 3 checks marcados")
  }
}
marcar = () => {
  let campo = window.document.getElementById("solo");

  if(!campo.checked){
    campo.checked = true;
  }
}

desmarcar = () => {
  let campo = window.document.getElementById("solo");
  
  if(campo.checked){
    campo.checked = false;
  }
}



window.document.addEventListener("DOMContentLoaded", iniciarPag);
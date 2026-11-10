var nombre;
var asigCheck;
var calificacion;

const inicio = () => {
  document.getElementById("boton").addEventListener("click", nuevaVentana);
}

const validar = () => {
  nombre = document.getElementById("nombre").value 
   arrayR = document.getElementsByName("asig")
   calificacion = document.getElementById("cali").value

  let cont = 0

  if(!isNaN(nombre) || nombre == ""){
    alert("Campo nombre invalido")
    return false;
  }else if (isNaN(calificacion) || calificacion > 10 || calificacion<0){
    alert("Campo calificacion invalidos")
    return false;
  }

 

  for (let i = 0; i < arrayR.length; i++) {
    if(arrayR[i].checked){
       asigCheck = arrayR[i].value
       cont++
    }
  }

  if(cont == 0){
    alert("Campo radio invalido")
    return false
  }

return true


}



const nuevaVentana = () => {
   let validacion=  validar()
    if(validacion== true){
  let v = window.open("hija.html","","width=400px, height=400px")

  v.addEventListener("load", () => {
    let mensaje;
     if (calificacion < 5) {
    mensaje = "Necesitas mejorar"
  }else if (calificacion >= 8){
    mensaje= "¡Excelente trabajo!"
  }else{
   mensaje = "¡Sigue esforzándote!"
  }
    v.document.getElementById("result").innerHTML = `Nombre: ${nombre} \n
                                                    Asignatura ${asigCheck} \n
                                                    Calificacion ${calificacion} \n
                                                    Mensaje ${mensaje}`
  })

    }

}

    
window.document.addEventListener("DOMContentLoaded", inicio)
var vTemp;

const inicio = () => {
 let hoy = new Date();
 let fechaDiv = window.document.getElementById("fecha")

 fechaDiv.innerHTML = `${hoy.getDate()}/${hoy.getMonth() + 1}/${hoy.getFullYear()}`

 window.document.getElementById("btnIniciar").addEventListener("click", sortear)
 window.document.getElementById("btnDetener").addEventListener("click", detener)
  window.document.getElementById("btnResumen").addEventListener("click", resumen)
}

const sortear = () => {
    window.document.getElementById("btnDetener").disabled = false;
    window.document.getElementById("btnIniciar").disabled = true;

    vTemp = setInterval(generarNumero, 1000)

    function generarNumero() {
        
        let numeroGanador = "";

        for (let i = 0; i < 5; i++) {
            let aleatorio = Math.floor(Math.random()*(9 - 0 +1)) + 0
             numeroGanador += aleatorio;
            
        }
        window.document.getElementById("numero").value = numeroGanador;
    }
  
}

const detener = () => {
  clearInterval(vTemp);
  window.document.getElementById("btnResumen").disabled = false;

  window.document.getElementById("btnDetener").disabled = true;
  window.document.getElementById("btnIniciar").disabled = true;

  let divR = window.document.getElementById("texto")
  let ganador = window.document.getElementById("numero")
  divR.innerHTML = `El numero ganador es ${ganador.value}`
}

const resumen = () => {
  let v = window.open("resumen.html","","width=500px, height=400px")
}

window.document.addEventListener("DOMContentLoaded", inicio)
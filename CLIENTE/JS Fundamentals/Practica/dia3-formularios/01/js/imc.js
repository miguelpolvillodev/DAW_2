// Escribe aquí tu código


const inicio = () => {
  window.document.getElementById("calcular").addEventListener("click", calcular)
}

const comprobar = () => {
 let peso = window.document.getElementById("peso").value
 let altura = window.document.getElementById("altura").value
 let div = window.document.getElementById("resultado")

 if(altura =="" ||peso ==""){
    div.style.color = "red"
    div.innerHTML = "Rellena todos los campos"
    return false
 }else if (isNaN(peso) || isNaN(altura) || peso<=0 || altura<=0){
    div.style.color = "red"
    div.innerHTML = "Introduce numeros validos"
    return false
 }else{
    return true
 }

     
}

const calcular = () => {
  if(comprobar()){
 let peso = window.document.getElementById("peso").value
 let altura = window.document.getElementById("altura").value / 100

 let imc = (peso / Math.pow(altura,2))
 let clasi;

 if(imc<18.5){
clasi = "Bajo peso"
 }else if(imc>=18.5 && imc<25){
    clasi = "Normal"
 }else if (imc>=25 && imc <30){
    clasi = "Sobrepeso"
 }else{
    clasi = "Obesidad"
 }
 window.document.getElementById("resultado").style.color = "blue"
window.document.getElementById("resultado").innerHTML = `Tu IMC es ${imc.toFixed(2)}: ${clasi}`

  }
}

window.addEventListener("DOMContentLoaded", inicio)
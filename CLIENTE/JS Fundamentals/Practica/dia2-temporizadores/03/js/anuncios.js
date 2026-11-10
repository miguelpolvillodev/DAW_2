// Escribe aquí tu código
var vTemp;
var vTemp2;
var cont = 0
var segundos = 0
var frases = ["Oferta 2x1", "Nuevo curso de JavaScript", "Descuentos de otoño", "Última hora"]

const inicio = () => {
  
    vTemp = setInterval(mostrarAnuncio, 2000)
    vTemp2 = setInterval(mostrarSegundos, 1000)
    let vTemp3 = setTimeout(redirigir, 10000)

    window.document.getElementById("parar").addEventListener("click", pararAnuncios)
    
    

}

const mostrarAnuncio = () => {
   
  window.document.getElementById("anuncio").innerHTML = frases[cont]
   cont++;
  
  if(cont == frases.length){
    cont = 0;
  }
}

const pararAnuncios = () => {
  clearInterval(vTemp)
}

const mostrarSegundos = () => {
  segundos++
  window.document.getElementById("contador").innerHTML = `Llevas ${segundos} segundos`
  
}

const redirigir = () => {
    document.getElementById("anuncio").style.display = "none"
    clearInterval(vTemp)
    clearInterval(vTemp2)

    window.location.href ="fin.html"
    
  
}



window.addEventListener("DOMContentLoaded", inicio)



const continentes = ["Europa","America", "Rusia","África"]
const arrayE = ["Primavera","Verano","Otoño","Invierno"]

inicio = () => {
  let h2 = document.createElement("h2")
  h2.innerHTML = "Estaciones"
  document.body.appendChild(h2)
  
  let ul = document.createElement("ul")
 
  

 
  for (let i = 0; i < arrayE.length; i++) {
     let li = document.createElement("li")
     li.innerHTML = arrayE[i]
     ul.appendChild(li)
  
  }
  
  document.body.appendChild(ul)




  let h22 = document.createElement("h2")
  h22.innerHTML = "Continentes"
  document.body.appendChild(h22)
  let ul2 = document.createElement("ul")

  for (let i = 0; i < continentes.length; i++) {
    let li2 = document.createElement("li")
    li2.innerHTML = continentes[i];
    ul2.appendChild(li2)
    
  }

document.body.appendChild(ul2)

}

window.document.addEventListener("DOMContentLoaded", inicio)
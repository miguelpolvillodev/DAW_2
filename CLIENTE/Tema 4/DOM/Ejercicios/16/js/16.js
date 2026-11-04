const inicio = () => {
  
    const tabla = document.createElement("table")
    tabla.style.border = "1px solid"

    for (let i = 0; i <= 2 ; i++) {
        const fila = document.createElement("th")
        fila.innerHTML = "hola"

        

        for (let j = 0; j <= 2; j++) {
            const celda = document.createElement("td")
            celda.innerHTML = "3"
            


            if(j === 1){
                celda.style.backgroundColor = "red"
            }else if (j === 2){
                celda.style.backgroundColor = "yellow"
                celda.style.fontWeight = "bold"
            }
            fila.appendChild(celda)
            tabla.appendChild(celda)
        }

        
    }
window.document.body.appendChild(tabla)
}


window.document.addEventListener("DOMContentLoaded", inicio)
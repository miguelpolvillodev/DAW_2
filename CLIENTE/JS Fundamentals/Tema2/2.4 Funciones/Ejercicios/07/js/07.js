let nuevaVentana = window.open("","07-segunda.html","width=700px, height=300px")

let num= nuevaVentana.prompt("Introduzca un numero entre 1 y 20")



let rellenar = (num) =>{
//window.document.write("<ul>");
window.document.body.innerHTML += `<ul>`
    for (let i = 1; i <= num; i++) {
        document.body.innerHTML += `<li>${i}</li>`
        
    }
//window.document.write("</ul>")
window.document.body.innerHTML += "</ul>"
}
nuevaVentana.close();
rellenar(num);




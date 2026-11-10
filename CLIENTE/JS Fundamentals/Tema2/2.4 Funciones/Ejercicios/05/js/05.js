let contenido = "";

let crearTabla = (filas = 10, columnas = 4, colorBorde = "black") =>{
    contenido = '<table style="width: 100%; border-collapse: collapse; border:3px solid' + colorBorde + ';">'

    for (let i = 0; i < filas; i++) {
       contenido += "<tr>"
        for (let j = 0; j<=a ; j++) {
           document.write(`<td style="border: 1px solid black;">fila ${j}</td>`)
        }
   }
}

let porDefecto = (a,b) =>{
    document.write(`<table>`)
   for (let i = 0; i <= b; i++) {
       document.write(`<th style="border: 1px solid black;">Columna ${i}</th> <br>`)
        for (let j = 0; j<=a ; j++) {
           document.write(`<td style="border: 1px solid black;">fila ${j}</td>`)
        }
   }
    document.write(`</table>`)
}
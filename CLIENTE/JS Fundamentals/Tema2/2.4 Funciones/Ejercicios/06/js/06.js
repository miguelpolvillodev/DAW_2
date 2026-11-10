var nuevaVentana;

let abrirVentana = () => {
    nuevaVentana = window.open("","06-segunda.html","width =400px, height=400px")
    let hoy = new Date().getDay();

    if(hoy == 0 || hoy == 6){
        nuevaVentana.document.body.innerHTML = `<img src="img/ok.jpeg"/>`;
    }else{
        nuevaVentana.document.body.innerHTML = `<img src="img/bad.jpeg"/>`;
    }
}
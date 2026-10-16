const cargarPag = () => {
  let res = confirm("Quieres cambiar el texto?")

if(res){
    document.getElementById("texto").innerHTML = "Texto cambiado";
}else{
    var res2 = confirm("Quieres cambiar el color de la letra?")

}

if(res2){
document.getElementById("texto").style.color="orange";

}else{
    window.close()
}
}


window.document.addEventListener("DOMContentLoaded", cargarPag);
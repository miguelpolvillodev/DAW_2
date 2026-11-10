// Escribe aquí tu código
const productos = [
 { id: "p1", nombre: "Teclado", precio: 25, stock: "100" },
 { id: "p2", nombre: "Ratón", precio: 12, stock: "20" },
 { id: "p3", nombre: "Monitor", precio: 150, stock: "2" },
 { id: "p4", nombre: "Webcam", precio: 40, stock: "120" }
];
var vTemp;
var numCheck = 0;


const inicio = () => {
    for (let i = 0; i < productos.length; i++) {
    crearFila(productos[i])
  }
  vTemp = setInterval(reloj, 1000);
  reloj();
  total();

  window.document.getElementById("add").addEventListener("click", añadir)
  window.document.getElementById("borrar").addEventListener("click", eliminarMarcadas)
  
};

const reloj = () => {
  let ahora = new Date();

  let h = ahora.getHours();
  let min = ahora.getMinutes();
  let sec = ahora.getSeconds();

  if (h == 0) {
    h = "0";
  }else if (h < 10){
    h = "0" + h;
  }
  if (min < 10) {
    min = "0" + min;
  }
  if (sec < 10) {
    h = "0" + sec;
  }
  document.getElementById("reloj").innerHTML = `${h}:${min}:${sec}`;
};



const crearFila = (p) => {
  const tr = document.createElement("tr");
  tr.id = p.id;
  const td1 = document.createElement("td");
  td1.innerHTML = p.nombre;
  const td2 = document.createElement("td");
  td2.innerHTML = p.precio;
  const td3 = document.createElement("td");
  td3.innerHTML = p.stock;
  tr.appendChild(td1);
  tr.appendChild(td2);
  tr.appendChild(td3);

  
    crearCheckbox(tr); 
 

  document.getElementById("cuerpoTabla").appendChild(tr)
};

const crearCheckbox = (tr) => {
 numCheck++;
 const td = document.createElement("td");
 const check = document.createElement("input");
 check.type = "checkbox";
 check.id = "checkbox" + numCheck;
 check.name = "marcar";
 td.appendChild(check);
 tr.appendChild(td);
}

const añadir = () => {
   

   let nombre = document.getElementById("nombreN")
   let precio = document.getElementById("precioN")
   let stock = document.getElementById("stockN")
   let div = document.getElementById("error")

   div.style.color = ""
   div.innerHTML = ""

   if(nombre.value == ""){
    div.style.color = "red"
    div.innerHTML = "Escribe el nombre del producto"
   }else if (precio.value < 0){
    div.style.color = "red"
    div.innerHTML = "El precio debe ser un número mayor que 0"
   }else if(!Number(precio.value) || precio.value <= 0 ){
    div.style.color = "red"
    div.innerHTML = "El stock debe ser un número entero mayor o igual que 0"
   }else{
 const nuevo = {
 id: "p" + Date.now(),
 nombre: nombre.value ,
 precio: precio.value,
 stock:stock.value 
 };
 crearFila(nuevo);
 nombre.value =""
 precio.value=""
 stock.value = ""
 nombre.focus()
   }

 
}

const eliminarMarcadas = () => {
    document.getElementById("error").style.color = ""
    document.getElementById("error").innerHTML = ""
    let encontrado = false;
 const checks = document.getElementsByName("marcar");

 for (let i = checks.length - 1; i >= 0; i--) { 
 if (checks[i].checked) {
 checks[i].parentNode.parentNode.remove(); 
 encontrado = true
 }
 }

 if(encontrado == false){
 document.getElementById("error").style.color = "red"
    document.getElementById("error").innerHTML = "No  hay  ningún  producto marcado"
 }else{
 total()
 }
 
};

const total = () => {
  let tbody = document.getElementById("cuerpoTabla")
  let tr = tbody.getElementsByTagName("tr")
  let div = document.getElementById("total")
  let total = 0;

  

  for (let i = 0; i < productos.length; i++) {
    total += productos[i].precio
    
  }
  div.innerHTML = `Productos: ${tr.length} Importe total: ${total} euros.`
  
}


window.document.addEventListener("DOMContentLoaded", inicio);

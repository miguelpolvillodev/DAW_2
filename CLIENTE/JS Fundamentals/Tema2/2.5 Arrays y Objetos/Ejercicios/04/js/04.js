var arrayProductos = new Array();

let Producto1 = {
    nombre: "Colacao",
    precio:5,
    categoria: "Comida"
};
let Producto2 = {
    nombre: "Filetes Pollo",
    precio:6,
    categoria: "Comida"
};
let Producto3 = {
    nombre: "Pasta Dientes",
    precio:2,
    categoria: "Aseo"
};
let Producto4 = {
    nombre: "Vasos Plástico",
    precio:2,
    categoria: "Cubiertos"
};

arrayProductos.push(Producto1);
arrayProductos.push(Producto2);
arrayProductos.push(Producto3);
arrayProductos.push(Producto4);

const newArr = arrayProductos.map(el => el.nombre.toUpperCase());
console.log(newArr);
document.body.innerHTML += `${newArr.join("-")}`


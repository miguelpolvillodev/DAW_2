var arrayProductos = new Array();

let categoria1 = { nombre: "comida", descripcion: "consumible" };
let categoria2 = { nombre: "bien estar", descripcion: "cuidado personal" };
let categoria3 = { nombre: "comida", descripcion: "desayuno" };

let Producto1 = { nombre: "Colacao", precio: 5, categoria: categoria3 };
let Producto2 = { nombre: "Filetes Pollo", precio: 6, categoria: categoria1 };
let Producto3 = { nombre: "Pasta Dientes", precio: 2, categoria: categoria2 };
let Producto4 = { nombre: "Presa ibérica", precio: 2, categoria: categoria1 };

// 1. Array de productos
arrayProductos.push(Producto1, Producto2, Producto3, Producto4);
console.log(arrayProductos);

// 2. Nombres de productos de una categoría
let productosComida = arrayProductos.filter(p => p.categoria.nombre === "comida");
let nombresComida = productosComida.map(p => p.nombre);
console.log(nombresComida);

// 3. Detalles de los productos filtrados
productosComida.forEach(p => {
    console.log(
        `Producto: ${p.nombre} | Precio: ${p.precio}€ | ` +
        `Categoría: ${p.categoria.nombre} (${p.categoria.descripcion})`
    );
});
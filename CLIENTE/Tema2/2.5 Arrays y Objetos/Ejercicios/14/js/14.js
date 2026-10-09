var arrayLibros = [];
var tituloLibros = [];

let libro1 = { titulo: "El Quijote", nPag: 1250 };
let libro2 = { titulo: "Cien años de soledad", nPag: 471 };
let libro3 = { titulo: "1984", nPag: 328 };
let libro4 = { titulo: "El Señor de los Anillos", nPag: 1178 };
let libro5 = { titulo: "Don Juan Tenorio", nPag: 160 };
let libro6 = { titulo: "La sombra del viento", nPag: 487 };
let libro7 = { titulo: "Crimen y castigo", nPag: 551 };
let libro8 = { titulo: "El principito", nPag: 96 };
let libro9 = { titulo: "Fahrenheit 451", nPag: 158 };
let libro10 = { titulo: "Los pilares de la Tierra", nPag: 1040 };

arrayLibros.push(libro1, libro2, libro3, libro4, libro5, libro6, libro7, libro8, libro9, libro10);



arrayLibros.forEach((e) => {
    if(e.nPag > 300){
        tituloLibros.push(e.titulo);
    }
});

console.log(tituloLibros);
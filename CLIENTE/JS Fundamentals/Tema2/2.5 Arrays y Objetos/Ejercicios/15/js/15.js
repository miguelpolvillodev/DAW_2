var arrayEstudiantes = [];
var calificaciones = [0,1,2,3,4,5,6,7,8,9,10]

let estudiante1 = { nombre: "Belén", nota: [calificaciones[8], calificaciones[6], calificaciones[10]]};
let estudiante2 = { nombre: "Carlos", nota: [calificaciones[1], calificaciones[6], calificaciones[4]]};
let estudiante3 = { nombre: "Lucía", nota: [calificaciones[3], calificaciones[8], calificaciones[4]]};
let estudiante4 = { nombre: "Javier", nota: [calificaciones[5], calificaciones[8], calificaciones[4]]};
let estudiante5 = { nombre: "Marta", nota: [calificaciones[3], calificaciones[9], calificaciones[4]]};
let estudiante6 = { nombre: "Pablo", nota: [calificaciones[7], calificaciones[9], calificaciones[4]] };
let estudiante7 = { nombre: "Sofía", nota: [calificaciones[8], calificaciones[6], calificaciones[4]] };
let estudiante8 = { nombre: "Andrés", nota: [calificaciones[4], calificaciones[2], calificaciones[4]] };
let estudiante9 = { nombre: "Elena", nota: [calificaciones[8], calificaciones[2], calificaciones[4]] };
let estudiante10 = { nombre: "Raúl", nota: [calificaciones[10], calificaciones[2], calificaciones[4]] };

arrayEstudiantes.push(
    estudiante1, estudiante2, estudiante3, estudiante4, estudiante5,
    estudiante6, estudiante7, estudiante8, estudiante9, estudiante10
);


var arrayNotasIn = [];

arrayEstudiantes.forEach((e) => {
    let suma = 0;
    for (let i = 0; i < e.nota.length; i++) {
        suma += e.nota[i];
    }
    let media = suma / e.nota.length;

    arrayNotasIn.push({ nombre: e.nombre, media: media });
});

console.log(arrayNotasIn);

let superiorSiete = arrayNotasIn.filter(alumno => alumno.media > 7);

superiorSiete.forEach(alumno =>{
    console.log(alumno.nombre)
})
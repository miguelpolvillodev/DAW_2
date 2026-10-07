var arrayPersonas = new Array();
let Persona1 = {
    nombre: "Pedro",
    edad: 15,
    ciudad:"Sevilla"
};
let Persona2 = {
    nombre: "Marta",
    edad: 20,
    ciudad:"Jaén"
};
let Persona3 = {
    nombre: "Silvia",
    edad: 24,
    ciudad:"Jaén"
};
let Persona4 = {
    nombre: "Juan",
    edad: 17,
    ciudad:"Huelva"
};
let Persona5 = {
    nombre: "Miguel",
    edad: 21,
    ciudad:"Málaga"
};
arrayPersonas.push(Persona1);
arrayPersonas.push(Persona2);
arrayPersonas.push(Persona3);
arrayPersonas.push(Persona4);
arrayPersonas.push(Persona5);
console.log(arrayPersonas);

var mayorEdad = arrayPersonas.filter(persona => persona.edad >= 18);
document.body.innerHTML += `<h2>Personas mayor de edad</h2>`
document.body.innerHTML += `<ul>`
mayorEdad.forEach((e) => {
    document.body.innerHTML += `<li>${e.nombre}</li>`
    });
    document.body.innerHTML += `</ul>`

var localidad = arrayPersonas.filter(persona => persona.ciudad === ("Sevilla"));
document.body.innerHTML += `<h2>Lista Personas de Sevilla</h2>`
document.body.innerHTML += `<ul>`
localidad.forEach((e) => {
    document.body.innerHTML += `<li>${e.nombre}</li>`
    });
    document.body.innerHTML += `</ul>`
var nombre;
mayus =()=> {
   nombre.value = nombre.value.toUpperCase();
   nombre.select()
    };
inicio = () => {
    nombre = document.getElementById("nombre-apellidos");
    nombre.addEventListener("blur", mayus);
   
};

window.addEventListener("DOMContentLoaded",inicio);


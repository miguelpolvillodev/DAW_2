const inicioPag = () => {
    document.getElementById("boton1").addEventListener("click", verCity);
    document.getElementById("boton2").addEventListener("click", verCities);
};

const verCity = () => {
    const select = document.getElementById("provincias");
    const indice = select.selectedIndex;
    const opcion = select.options[indice];

    alert(`Índice: ${indice}\nDescripción: ${opcion.text}\nValor: ${opcion.value}`);
};

const verCities = () => {
    const select = document.getElementById("provincias2");
    const seleccionadas = [];

    for (let i = 0; i < select.options.length; i++) {
        if (select.options[i].selected) {
            seleccionadas.push(select.options[i].text);
        }
    }

    alert(seleccionadas.join(", "));
};

document.addEventListener("DOMContentLoaded", inicioPag);
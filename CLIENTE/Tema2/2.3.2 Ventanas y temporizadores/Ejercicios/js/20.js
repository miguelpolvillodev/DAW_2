let vTemp1 = setInterval(mostrarConsola, 2000);
function mostrarConsola() {
  console.log(`En un lugar de la Mancha`);
}

function para() {
  clearInterval(vTemp1);
}

function tresSegundos() {
  console.log(`Han pasado tres segundos`);
}
function iniciarTemp() {
  let vTemp2 = setTimeout(tresSegundos, 3000);
}

function ventanaNueva() {
  let nuevaVentana = window.open("20-segunda.html", "", "width=300,height=300");

  nuevaVentana.document.write("<h1>Texto</h1>");
  let horaActual = new Date();
  nuevaVentana.document.body.innerHTML = horaActual.toLocaleTimeString();
  let corte = 0;
  let vTemp3 = setInterval(sumarSegundos, 1000);

  function sumarSegundos() {
    if (corte < 5) {
      let horaActual = new Date();
      nuevaVentana.document.body.innerHTML = horaActual.toLocaleTimeString();
      corte++;
    } else if (corte == 10) {
      clearInterval(vTemp3);
      nuevaVentana.window.close();
    } else {
      corte++;
    }
  }
}

var vTemp1 = setInterval(mostrarConsola, 2000);
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
  setTimeout(tresSegundos, 3000);
}

var nuevaVentana;
function ventanaNueva() {
  nuevaVentana = window.open("20-segunda.html", "", "width=300,height=300");

  //nuevaVentana.document.write("<p>Hola</p>");

  let corte = 0;
  let vTemp3 = setInterval(sumarSegundos, 1000);

  function sumarSegundos() {
    nuevaVentana.document.body.innerHTML = "<p>inner</p>";

    if (corte < 5) {
      let horaActual = new Date();
      nuevaVentana.document.body.innerHTML +=
        "<br>" + horaActual.toLocaleTimeString();
      corte++;
    } else if (corte == 10) {
      clearInterval(vTemp3);
      nuevaVentana.window.close();
    } else {
      corte++;
    }
  }
}

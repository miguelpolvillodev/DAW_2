var vTemp = setInterval(cambiaColor, 1000);
function cambiaColor() {
  if (document.body.style.backgroundColor == "red") {
    document.body.style.backgroundColor = "green";
  } else if (document.body.style.backgroundColor == "green") {
    document.body.style.backgroundColor = "blue";
  } else if (document.body.style.backgroundColor == "blue") {
    document.body.style.backgroundColor = "red";
  } else {
    document.body.style.backgroundColor = "red";
  }
}

function detener() {
  clearInterval(vTemp);
}

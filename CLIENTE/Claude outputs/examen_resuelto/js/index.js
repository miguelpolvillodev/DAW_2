var alumnos = [];        // array global: cada alumno es un objeto literal
var vReloj;              // temporizador del reloj (global para poder pararlo)
var ventana;             // ventana hija (global)

function inicio() {
  actualizarReloj();                                              // 1. se ve ya, sin esperar 1 s
  vReloj = setInterval(actualizarReloj, 1000);
  document.getElementById("btnParar").addEventListener("click", pararReloj);

  document.getElementById("nombre").addEventListener("blur", mayusculas);           // 2. eventos
  document.getElementById("formulario").addEventListener("submit", validar);        // 3. formulario
  document.getElementById("btnResumen").addEventListener("click", abrirResumen);    // 5. ventanas
}

// ---------- 1. TEMPORIZADORES + DATE + FUNCIÓN FLECHA ----------
const actualizarReloj = () => {
  const ahora = new Date();                                       // se lee dentro: cada segundo
  let h = 23 - ahora.getHours();
  let m = 59 - ahora.getMinutes();
  let s = 59 - ahora.getSeconds();
  if (h < 10) { h = "0" + h; }                                    // dos dígitos
  if (m < 10) { m = "0" + m; }
  if (s < 10) { s = "0" + s; }
  document.getElementById("reloj").value = `${h}:${m}:${s}`;
};

function pararReloj() {
  clearInterval(vReloj);
  document.getElementById("btnParar").style.backgroundColor = "red";
}

// ---------- 2. EVENTOS ----------
function mayusculas() {
  let n = document.getElementById("nombre");
  n.value = n.value.toUpperCase();
}

// ---------- 3. FORMULARIOS: VALIDAR (solo el primer error) ----------
function validar(e) {
  e.preventDefault();                                             // evita que el form recargue la página
  let nombre = document.getElementById("nombre").value.trim();
  let edad = document.getElementById("edad").value.trim();
  let curso = document.getElementById("curso").value;
  let mensaje = document.getElementById("mensaje");

  // radio: recorrer el grupo y ver cuál está marcado
  let modalidad = "";
  let radios = document.getElementsByName("modalidad");
  for (let i = 0; i < radios.length; i++) {
    if (radios[i].checked) {
      modalidad = radios[i].value;
    }
  }

  // checkbox: guardar los marcados en un array
  let asignaturas = [];
  let checks = document.getElementsByName("asig");
  for (let i = 0; i < checks.length; i++) {
    if (checks[i].checked) {
      asignaturas.push(checks[i].value);
    }
  }

  mensaje.style.color = "red";
  if (nombre == "") {
    mensaje.innerHTML = "El nombre es obligatorio";
  } else if (edad == "" || isNaN(edad) || edad < 0 || edad > 105) {
    mensaje.innerHTML = "La edad debe ser un número entre 0 y 105";
  } else if (curso == "0") {
    mensaje.innerHTML = "Elige un curso";
  } else if (modalidad == "") {
    mensaje.innerHTML = "Elige una modalidad";
  } else if (asignaturas.length == 0) {
    mensaje.innerHTML = "Marca al menos una asignatura";
  } else {
    // todo correcto
    let alumno = { nombre: nombre, edad: Number(edad), curso: curso, modalidad: modalidad, asignaturas: asignaturas };
    alumnos.push(alumno);
    crearFila(alumno);                                            // 4. DOM
    mensaje.style.color = "green";
    mensaje.innerHTML = "Alumno añadido";
    document.getElementById("formulario").reset();                // vacía el formulario
    document.getElementById("nombre").focus();                    // y deja el foco en el nombre
  }
}

// ---------- 4. DOM: CREAR FILA Y BORRARLA ----------
function crearFila(alumno) {
  let tr = document.createElement("tr");                          // 1. crear

  let datos = [alumno.nombre, alumno.edad, alumno.curso, alumno.modalidad, alumno.asignaturas.join(", ")];
  for (let i = 0; i < datos.length; i++) {
    let td = document.createElement("td");
    td.innerHTML = datos[i];                                      // 2. rellenar
    tr.appendChild(td);                                           // 3. colgar
  }

  let tdBorrar = document.createElement("td");
  let boton = document.createElement("button");
  boton.type = "button";
  boton.innerHTML = "Borrar";
  boton.addEventListener("click", function () {
    tr.remove();                                                  // quita la fila de la página
    alumnos.splice(alumnos.indexOf(alumno), 1);                   // y el alumno del array
  });
  tdBorrar.appendChild(boton);
  tr.appendChild(tdBorrar);

  // 2. EVENTOS: resaltar la fila al pasar el ratón
  tr.addEventListener("mouseover", function () { tr.style.backgroundColor = "yellow"; });
  tr.addEventListener("mouseout", function () { tr.style.backgroundColor = ""; });

  document.getElementById("cuerpo").appendChild(tr);
}

// ---------- 5. VENTANAS + 6. TEMPORIZADOR ----------
function abrirResumen() {
  ventana = window.open("resumen.html", "", "width=400,height=300");
  setTimeout(cerrarResumen, 5000);                                // a los 5 segundos
}

function cerrarResumen() {
  ventana.close();
  let aviso = document.getElementById("aviso");
  aviso.innerHTML = "Resumen consultado a las " + new Date().toLocaleTimeString();
  aviso.style.color = "blue";
}

document.addEventListener("DOMContentLoaded", inicio);

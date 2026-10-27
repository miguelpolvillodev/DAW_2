inicio = () => {
  document.getElementById("boton").addEventListener("click", generaForm)
}

const generaForm = () => {
  let padre = document.getElementById("ContentFormulario")
  let form = document.createElement("form")
  padre.appendChild(form)
  form.style.width = "300px"
  form.action = "https://google.com"
  form.method = "GET"

  let nombre = document.createElement("input")
  form.appendChild(nombre)
  nombre.type ="text"
  nombre.placeholder ="Nombres"
  nombre.style.width = "100%"
  nombre.style.margin = "10px 0px"
  nombre.style.padding = "5px"

  let apellidos = document.createElement("input")
  form.appendChild(apellidos)
  apellidos.type ="text"
  apellidos.placeholder ="Apellidos"
  apellidos.style.width = "100%"
  apellidos.style.margin = "10px 0px"
  apellidos.style.padding = "5px"

  let email = document.createElement("input")
  form.appendChild(email)
  email.type ="text"
  email.placeholder ="Email"
  email.style.width = "100%"
  email.style.margin = "10px 0px"
  email.style.padding = "5px"

  let asunto = document.createElement("input")
  form.appendChild(asunto)
  asunto.type ="text"
  asunto.placeholder ="Email"
  asunto.style.width = "100%"
  asunto.style.margin = "10px 0px"
  asunto.style.padding = "5px"

  let mensaje = document.createElement("input")
  form.appendChild(mensaje)
  mensaje.type ="text"
  mensaje.placeholder ="Mensaje"
  mensaje.style.width = "100%"
  mensaje.style.height = "200px"
  asunto.style.margin = "10px 0px"
  asunto.style.padding = "5px"

  let boton = document.createElement("input")
  form.appendChild(boton)
  boton.type = "button"
  boton.value = "Enviar"
  boton.style.width = "100px"
  boton.style.margin = "10px 0px"
  boton.style.padding = "10px"
  boton.style.backgroundColor ="#f05133"
  boton.style.color = "fff"
  boton.style.border = "solid 1px #000"
  boton.id ="enviar"

  document.getElementById("enviar").addEventListener("click", () => {
    alert("has clicadoo!")
  })
};


window.document.addEventListener("DOMContentLoaded", inicio)
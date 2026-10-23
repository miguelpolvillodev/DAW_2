
inicio = () => {
  let body = document.body
  let link = body.firstElementChild;

  alert(`${link.href} | ${link.style.color} | ${link.style.font}`)
}

window.document.addEventListener("DOMContentLoaded", inicio)
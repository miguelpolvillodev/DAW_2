inicio = () => {
  const p = document.getElementsByTagName("p");

  let body = document.body;

  body.removeChild(p[0]);
};

window.document.addEventListener("DOMContentLoaded", inicio);

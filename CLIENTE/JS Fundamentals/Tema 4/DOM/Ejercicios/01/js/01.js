iniciarPag = () => {
  const padreDiv = window.document.getElementById("myDIV")

  
  padreDiv.firstElementChild.style.backgroundColor = "yellow";
  padreDiv.lastElementChild.style.backgroundColor = "orange";

  
  let p = padreDiv.getElementsByTagName("p");

  for (let i = 0; i < p.length; i++) {
    p[i].style.color = "red";
    
  }
}

window.document.addEventListener("DOMContentLoaded", iniciarPag);
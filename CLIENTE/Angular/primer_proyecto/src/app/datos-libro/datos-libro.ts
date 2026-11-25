import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [FormsModule],
  selector: 'app-datos-libro',
  styleUrl: './datos-libro.css',
  templateUrl: './datos-libro.html',
})
export class DatosLibro {
  libro = {
    titulo: "Harry Potter",
    autor: "JK Rowling",
    precio: 30,
    stock: 0,
    cantidad: 100,
    imagen:"https://m.media-amazon.com/images/I/51eS6zoReQL._SY445_SX342_ML2_.jpg",
  }

  anadirLibro(evento:any) {
  this.libro.stock++;
}

eliminarLibro(evento:any) {
  if (this.libro.stock > 0) {
    this.libro.stock--;
  }
}

posRaton(evento:any){
  console.log(`X:${evento.clientX} Y:${evento.clientY}`);
}
  
  
}

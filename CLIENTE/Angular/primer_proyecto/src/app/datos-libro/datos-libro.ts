import { Component, EventEmitter, Input, Output } from '@angular/core';
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
  };
  libro2 = {
    titulo: "El señor de los Anillos",
    autor: "JRR Tolkien",
    precio: 13,
    stock: 0,
    cantidad: 100,
    imagen:"https://m.media-amazon.com/images/I/71ANmujYQpL._SY342_.jpg",
  }

  arrayLibros:any[] = [this.libro, this.libro2];

  @Input()
  numLibrosHijo:string = "";

  @Output()
  selected = new EventEmitter<string>();


  devolverLibro(){
    let numero: number = Number(this.numLibrosHijo);
    let tit;
    if(numero == 2 || numero ==1){
      tit = this.arrayLibros[numero - 1].titulo;
    }else{
      tit ='No existe el libro'
    }
    this.selected.emit(tit);
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

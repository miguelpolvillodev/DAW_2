import { Component } from '@angular/core';


@Component({
  imports: [],
  selector: 'app-counter',
  styleUrl: './counter.css',
  templateUrl: './counter.html',
})
export class Counter {
  contador: number = 10;

  aumentar() {
    this.contador++;
  }

  disminuir() {
    if(this.contador <= 0){
      this.contador++;
    }
    this.contador--;
  }
  resetear() {
    this.contador = 10;
  }
}

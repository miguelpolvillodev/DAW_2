import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [FormsModule],
  selector: 'app-reloj',
  styleUrl: './reloj.css',
  templateUrl: './reloj.html',
})
export class Reloj {
  valor1: number = 0;
  valor2: number = 0;

  resultado: number = 0;

  sumar() {
    this.resultado = this.valor1 + this.valor2;
  }
  restar() {
    this.resultado = this.valor1 - this.valor2;
  }
  multiplicar() {
    this.resultado = this.valor1 * this.valor2;
  }
  dividir() {
    if (this.valor1 == 0) {
      this.resultado = 0;
    } else {
      this.resultado = this.valor1 / this.valor2;
    }
  }
}

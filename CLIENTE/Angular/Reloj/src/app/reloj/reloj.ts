import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [FormsModule],
  selector: 'app-reloj',
  styleUrl: './reloj.css',
  templateUrl: './reloj.html',
})
export class Reloj {
  hora: string = '12:00:00';
  horaP: String = '';

  ahora: Date = new Date();

  cambiarHora() {
    this.horaP = this.hora;
  }

  horas: number = 0;
  minutos: number = 0;
  segundos: number = 0;

  ngOnInit() {
    this.countdown();
    setInterval(() => this.countdown(), 1000);
  }

  countdown() {
    this.ahora = new Date();
    console.log(this.ahora);
    this.horas = this.ahora.getHours();
    this.minutos = this.ahora.getMinutes();
    this.segundos = this.ahora.getSeconds();

    console.log(this.segundos);
  }
}

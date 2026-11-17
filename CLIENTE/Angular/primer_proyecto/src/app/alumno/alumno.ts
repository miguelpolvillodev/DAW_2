import { Component } from '@angular/core';

@Component({
  imports: [],
  selector: 'app-alumno',
  styleUrl: './alumno.css',
  templateUrl: './alumno.html',
})
export class Alumno {

  titulo:string = "Componente Alumno"

  nombre:string = "Miguel"
  apellido:string ="Polvillo"
  edad:number = 27 
  dni:string = "76975961G"

  edadMultiplicada():number {
    return this.edad * 5
  }

  mayorEdad():string {
    if (this.edad >= 18) {
      return "Mayor de edad"
    } else {
      return "Menor de edad"
    }
  }
}

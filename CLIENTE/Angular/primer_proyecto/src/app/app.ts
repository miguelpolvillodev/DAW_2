import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserProfile } from './user-profile/user-profile';
import { Alumno } from './alumno/alumno';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, UserProfile, Alumno],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  title = 'Clase de Angular';
  nombre:string = "Miguel";
  edad:number = 18;

  marcado:boolean = true;
  deshabilitar:boolean = true;

  asignatura = {
    nombre: "Java",
    codigo: 1
  }

  getEdad():number {
    return this.edad;
  }

  mayorEdad():string{
    if(this.edad >= 18){
      return "Es mayor de edad";
    }else{
      return "Es menor de edad";
    }
  }


}

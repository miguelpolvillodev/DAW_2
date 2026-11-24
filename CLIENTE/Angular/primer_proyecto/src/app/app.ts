import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserProfile } from './user-profile/user-profile';
import { Alumno } from './alumno/alumno';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  //Escribiendo el nombre ya se hace el import solo
  imports: [FormsModule, RouterOutlet, UserProfile, Alumno],
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

  way:string = "";

  texto1:string =" ";
  texto2:string =" ";
  cambiarM(evento:any){
    this.texto2 = this.texto1.toUpperCase();
  }

  cambiarm(evento:any){
    this.texto1 = this.texto2.toLowerCase();
  }

  marcadoCheck:boolean = false;
  url:string = "https://www.ceuandalucia.es/"

  cambiarTexto(evento:any){
    
  }

  


}

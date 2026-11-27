import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserProfile } from './user-profile/user-profile';
import { Alumno } from './alumno/alumno';
import { FormsModule } from '@angular/forms';
import { DatosLibro } from './datos-libro/datos-libro';

@Component({
  selector: 'app-root',
  //Escribiendo el nombre ya se hace el import solo
  imports: [FormsModule, RouterOutlet, UserProfile, Alumno, DatosLibro],
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
  url:string = "https://www.ceuandalucia.es/";

  mostrar:string="mostrar";
  textoBoton:string="";
  verTexto:boolean = false;

  cambiarTexto(evento:any){
    if(evento.target.value == "ocultar"){
      this.mostrar = "mostrar"
      this.verTexto = true;
    }
    if(evento.target.value == "mostrar"){
      this.mostrar = "ocultar"
      this.verTexto = false;
    }
  }

  boton4:string="Habilitar"
  segundoBoton:boolean=true;

  cambiarHabilitador(evento:any){

    if(evento.target.value == "Habilitar"){
      this.boton4 = "Deshabilitar"
      this.segundoBoton = false;
    }

    if(evento.target.value == "Deshabilitar"){
      this.boton4 = "Habilitar"
      this.segundoBoton = true;
    }
    
  }

  valorHijo:string = ""
  seleccionarPadre(nombre: string){
    this.valorHijo = nombre;
  }

  numLibro:string = "";
  tituloLibro:string = ""
  mostrarTitulo(titulo: string){
    this.tituloLibro = titulo;
  }


}

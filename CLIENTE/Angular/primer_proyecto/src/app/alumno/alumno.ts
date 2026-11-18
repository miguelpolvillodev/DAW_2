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
  edad:number = 18 
  dni:string = "76975961G"

  desabilitado:boolean = true

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
  miTexto:string = ""
  escribirDiv(evento:any){
    this.miTexto = evento.target.value;
  }

  
   marcarMayor18():boolean {
    if (this.edad >= 18) {
      return true
    } else {
      return false
    }
  }

  texto:string = "Antes de pulsar"
  marcado:boolean = false;
  alerta(evento:any){
    if(evento.target.checked == true){
      alert("Marcado")
      this.marcado = true;
      this.texto = "check pulsado"
    }
  }

  texto2:string = ""
  radios(evento:any){
    if(evento.target.value == "P"){
      this.texto2 = "Pulsado PAR"
    }
    if(evento.target.value == "I"){
      this.texto2 = "Pulsado IMPAR"
    }
  }

  nombreCom:string = " "
  nombreCompi(){
    this.nombreCom = "Nacho"
  }

  textoP:string = " "
  mostrarP(evento:any){
    this.textoP += evento.target.value + ","
  }

  textoM:string = "";
  estaMarcado(evento:any){
    if(evento.target.checked == true){
      this.textoM = "Está marcado"
    }else{
      this.textoM= "No está marcado"
    }
  }
  
}

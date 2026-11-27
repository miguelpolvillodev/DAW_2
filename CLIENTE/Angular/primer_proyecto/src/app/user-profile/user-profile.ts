import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  imports: [],
  selector: 'app-user-profile',
  styleUrl: './user-profile.css',
  templateUrl: './user-profile.html',
})
export class UserProfile {

  nombre:string = "Pepe"
  rol:string = "IT Support"
  titulo:string ="Componente User"

  imagen:string = "./img/perro.jpg"
  orange:string = "naranja"

  @Input()
  name:string = "";

  @Input()
  role:string = "";

  @Output()
  selected = new EventEmitter<string>();

  seleccionar(){
    this.selected.emit(this.name);
  }

  getNombre() : string {
    return this.nombre;
  }
  getRol() : string {
    return this.rol;
  }

  

  

}

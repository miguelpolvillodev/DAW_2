import { Component } from '@angular/core';

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


  
  getNombre() : string {
    return this.nombre;
  }
  getRol() : string {
    return this.rol;
  }

  

}

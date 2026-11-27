import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Reloj } from './reloj/reloj';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Reloj],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('Reloj');
}

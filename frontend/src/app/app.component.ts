import { Component } from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink],
  template: `
    <div class="container">
      <h1>Gestión de Clínicas</h1>
      <nav>
        <a routerLink="/clinicas">Listado de Clínicas</a>
        <a routerLink="/clinicas/nueva">Nueva Clínica</a>
      </nav>
      <router-outlet></router-outlet>
    </div>
  `
})
export class AppComponent {
  title = 'clinica-frontend';
}

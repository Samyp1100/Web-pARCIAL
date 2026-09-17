import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { ClinicaService } from '../../services/clinica.service';
import { Clinica } from '../../models/clinica.model';

@Component({
  selector: 'app-clinica-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  template: `
    <div>
      <h2>Listado de Clínicas</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Dirección</th>
            <th>Camas</th>
            <th>Teléfono</th>
            <th>Correo</th>
            <th>Fecha Creación</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          <tr *ngFor="let clinica of clinicas">
            <td>{{ clinica.identificador }}</td>
            <td>{{ clinica.nombre }}</td>
            <td>{{ clinica.direccion }}</td>
            <td>{{ clinica.cantidadCamas }}</td>
            <td>{{ clinica.telefono }}</td>
            <td>{{ clinica.correo }}</td>
            <td>{{ clinica.fechaCreacion }}</td>
            <td>
              <button (click)="eliminar(clinica.identificador!)">Eliminar</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  `
})
export class ClinicaListComponent implements OnInit {
  clinicas: Clinica[] = [];

  constructor(private clinicaService: ClinicaService) { }

  ngOnInit(): void {
    this.cargarClinicas();
  }

  cargarClinicas(): void {
    this.clinicaService.obtenerTodas().subscribe({
      next: (data) => this.clinicas = data,
      error: (error) => console.error('Error al cargar clínicas:', error)
    });
  }

  eliminar(id: number): void {
    if (confirm('¿Está seguro de eliminar esta clínica?')) {
      this.clinicaService.eliminar(id).subscribe({
        next: () => this.cargarClinicas(),
        error: (error) => console.error('Error al eliminar:', error)
      });
    }
  }
}

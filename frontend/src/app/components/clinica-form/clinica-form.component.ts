import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ClinicaService } from '../../services/clinica.service';
import { Clinica } from '../../models/clinica.model';

@Component({
  selector: 'app-clinica-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <div>
      <h2>Nueva Clínica</h2>
      <form (ngSubmit)="guardar()">
        <div class="form-group">
          <label>Nombre:</label>
          <input type="text" [(ngModel)]="clinica.nombre" name="nombre" required>
        </div>

        <div class="form-group">
          <label>Dirección:</label>
          <input type="text" [(ngModel)]="clinica.direccion" name="direccion" required>
        </div>

        <div class="form-group">
          <label>Cantidad de Camas:</label>
          <input type="number" [(ngModel)]="clinica.cantidadCamas" name="cantidadCamas" required>
        </div>

        <div class="form-group">
          <label>Teléfono:</label>
          <input type="text" [(ngModel)]="clinica.telefono" name="telefono" required>
        </div>

        <div class="form-group">
          <label>Correo:</label>
          <input type="email" [(ngModel)]="clinica.correo" name="correo" required>
        </div>

        <div class="form-group">
          <label>Fecha de Creación:</label>
          <input type="date" [(ngModel)]="clinica.fechaCreacion" name="fechaCreacion" required>
        </div>

        <button type="submit">Guardar</button>
        <button type="button" (click)="cancelar()">Cancelar</button>
      </form>
    </div>
  `
})
export class ClinicaFormComponent {
  clinica: Clinica = {
    nombre: '',
    direccion: '',
    cantidadCamas: 0,
    telefono: '',
    correo: '',
    fechaCreacion: ''
  };

  constructor(
    private clinicaService: ClinicaService,
    private router: Router
  ) { }

  guardar(): void {
    this.clinicaService.crear(this.clinica).subscribe({
      next: () => {
        alert('Clínica creada exitosamente');
        this.router.navigate(['/clinicas']);
      },
      error: (error) => console.error('Error al crear clínica:', error)
    });
  }

  cancelar(): void {
    this.router.navigate(['/clinicas']);
  }
}

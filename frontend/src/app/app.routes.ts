import { Routes } from '@angular/router';
import { ClinicaListComponent } from './components/clinica-list/clinica-list.component';
import { ClinicaFormComponent } from './components/clinica-form/clinica-form.component';

export const routes: Routes = [
  { path: '', redirectTo: '/clinicas', pathMatch: 'full' },
  { path: 'clinicas', component: ClinicaListComponent },
  { path: 'clinicas/nueva', component: ClinicaFormComponent }
];

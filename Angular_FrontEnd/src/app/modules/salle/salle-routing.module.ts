import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GestionSalleComponent } from './components/gestion-salle/gestion-salle.component';

const routes: Routes = [
  {path: 'gestion/:id', component: GestionSalleComponent},
  {path: '**', component: GestionSalleComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SalleRoutingModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateInscriptionComponent } from './components/create-inscription/create-inscription.component';
import { ListByApprenantComponent } from './components/list-by-apprenant/list-by-apprenant.component';

const routes: Routes = [
  {path: 'create/session/:id', component: CreateInscriptionComponent},
  {path: 'lister/dashboard', component: ListByApprenantComponent},
  {path: 'lister/apprenant/:id', component: ListByApprenantComponent},
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InscriptionRoutingModule { }

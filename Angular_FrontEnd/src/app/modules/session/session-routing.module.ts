import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GestionSessionComponent } from './components/gestion-session/gestion-session.component';
import { ListSessionByFormationComponent } from './components/list-session-by-formation/list-session-by-formation.component';

const routes: Routes = [
  {path: 'gestion', component: GestionSessionComponent},
  {path: 'lister/formation/:id', component: ListSessionByFormationComponent},
  {path: 'gestion/:id', component: GestionSessionComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SessionRoutingModule { }

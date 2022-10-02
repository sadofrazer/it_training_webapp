import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardFormationComponent } from './components/dashboard-formation/dashboard-formation.component';
import { DashboardLogistiqueComponent } from './components/dashboard-logistique/dashboard-logistique.component';

const routes: Routes = [
  { path: 'dashboard_logistique', component: DashboardLogistiqueComponent },
  { path: 'dashboard_formation', component: DashboardFormationComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }

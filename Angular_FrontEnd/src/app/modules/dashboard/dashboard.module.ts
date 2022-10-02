import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardFormationComponent } from './components/dashboard-formation/dashboard-formation.component';
import { DashboardLogistiqueComponent } from './components/dashboard-logistique/dashboard-logistique.component';
import { DashboardLogistiqueSessionComponent } from './components/dashboard-logistique-session/dashboard-logistique-session.component';
import { DashboardFormationSessionComponent } from './components/dashboard-formation-session/dashboard-formation-session.component';
import { CoreModule } from '../core/core.module';


@NgModule({
  declarations: [
    DashboardFormationComponent,
    DashboardLogistiqueComponent,
    DashboardLogistiqueSessionComponent,
    DashboardFormationSessionComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    FormsModule,
    CoreModule
  ]
})
export class DashboardModule { }

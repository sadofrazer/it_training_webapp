import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SalleRoutingModule } from './salle-routing.module';
import { GestionSalleComponent } from './components/gestion-salle/gestion-salle.component';
import { FormsModule } from '@angular/forms';
import { NgbAccordionModule } from '@ng-bootstrap/ng-bootstrap';
import { CoreModule } from '../core/core.module';


@NgModule({
  declarations: [
    GestionSalleComponent
  ],
  imports: [
    CommonModule,
    SalleRoutingModule,
    FormsModule,
    NgbAccordionModule,
    CoreModule
  ]
})
export class SalleModule { }

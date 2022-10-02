import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InscriptionRoutingModule } from './inscription-routing.module';
import { CreateInscriptionComponent } from './components/create-inscription/create-inscription.component';
import { FormsModule } from '@angular/forms';
import { NgbAccordionModule } from '@ng-bootstrap/ng-bootstrap';
import { ListByApprenantComponent } from './components/list-by-apprenant/list-by-apprenant.component';


@NgModule({
  declarations: [

  
    CreateInscriptionComponent,
        ListByApprenantComponent
  ],
  imports: [
    CommonModule,
    InscriptionRoutingModule,
    FormsModule,
    NgbAccordionModule
  ]
})
export class InscriptionModule { }

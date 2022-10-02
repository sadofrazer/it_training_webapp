import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatTabsModule} from '@angular/material/tabs';
import {MatChipsModule} from '@angular/material/chips';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import { MatInputModule } from '@angular/material/input';

import { SessionRoutingModule } from './session-routing.module';
import { GestionSessionComponent } from './components/gestion-session/gestion-session.component';
import { ListSessionByFormationComponent } from './components/list-session-by-formation/list-session-by-formation.component';
import { FormsModule, ReactiveFormsModule,  } from '@angular/forms';
import { NgbAccordion, NgbAccordionModule } from '@ng-bootstrap/ng-bootstrap';
import { CoreModule } from '../core/core.module';


@NgModule({
  declarations: [
    GestionSessionComponent,
    ListSessionByFormationComponent,
    
  ],
  imports: [
    CommonModule,
    SessionRoutingModule,
    FormsModule,
    NgbAccordionModule,
    CoreModule,
    MatTabsModule,
    MatChipsModule,
    MatFormFieldModule,
    MatIconModule,
    MatAutocompleteModule,
    MatInputModule,
    ReactiveFormsModule

  ],
  exports: [
    
  ]
})
export class SessionModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormationRoutingModule } from './formation-routing.module';
import { ListByThemeComponent } from './components/list-by-theme/list-by-theme.component';
import { HttpClientModule } from '@angular/common/http';
import { ListBySthemeComponent } from './components/list-by-stheme/list-by-stheme.component';
import { DetailFormationComponent } from './components/detail-formation/detail-formation.component';
import { GestionFormationComponent } from './components/gestion-formation/gestion-formation.component';
import { FormsModule } from '@angular/forms';
import { DataTableDirective, DataTablesModule } from 'angular-datatables';
import { CoreModule } from '../core/core.module';
import { CatalogueComponent } from './components/catalogue/catalogue.component';

@NgModule({
  declarations: [
    ListByThemeComponent,
    ListBySthemeComponent,
    DetailFormationComponent,
    GestionFormationComponent,
    CatalogueComponent,
  ],
  imports: [
    CommonModule,
    FormationRoutingModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    DataTablesModule,
    CoreModule
  ]
})
export class FormationModule { }

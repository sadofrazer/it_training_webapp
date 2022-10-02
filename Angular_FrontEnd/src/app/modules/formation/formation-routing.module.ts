import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogueComponent } from './components/catalogue/catalogue.component';
import { DetailFormationComponent } from './components/detail-formation/detail-formation.component';
import { GestionFormationComponent } from './components/gestion-formation/gestion-formation.component';
import { ListBySthemeComponent } from './components/list-by-stheme/list-by-stheme.component';
import { ListByThemeComponent } from './components/list-by-theme/list-by-theme.component';

const routes: Routes = [ 
{path: 'lister/:id', component: ListBySthemeComponent},
{path: 'details/:id', component: DetailFormationComponent},
{path: 'gestion/:id', component: GestionFormationComponent},
{path: 'gestion/catalogue', component: GestionFormationComponent},
{path: 'catalogue', component: CatalogueComponent},
{path: 'theme/:word', component: ListByThemeComponent},
{path: '**', component: CatalogueComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FormationRoutingModule { }

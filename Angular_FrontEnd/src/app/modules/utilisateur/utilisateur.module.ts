import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {  RouterModule, Routes } from '@angular/router';
import { ModifUtilisateurComponent } from './modif-utilisateur/modif-utilisateur.component';
import { AjoutUtilisateurComponent } from './ajout-utilisateur/ajout-utilisateur.component';
import { ListUtilisateurComponent } from './list-utilisateur/list-utilisateur.component';
import { DetailUtilisateurComponent } from './detail-utilisateur/detail-utilisateur.component';

import { UtilisateurFormComponent } from './utilisateur-form/utilisateur-form.component';
import { FormsModule } from '@angular/forms';
import { UtilisateurService } from './utilisateur.service';
import { SearchUtilisateurComponent } from './search-utilisateur/search-utilisateur.component';
import { LoderComponent } from './loder/loder.component';
import {matTabsAnimations, MatTabsModule} from '@angular/material/tabs';


//canActivate: [AuthGuard]
const utilisateurroutes: Routes =[
  { path: 'modif/utilisateur/:idUtilisateur', component:ModifUtilisateurComponent },
  { path: 'utilisateur/ajout', component: AjoutUtilisateurComponent},
  { path: 'utilisateurs', component: ListUtilisateurComponent},
  { path: 'utilisateur/:idUtilisateur', component: DetailUtilisateurComponent }
]
@NgModule({
  declarations: [
    ListUtilisateurComponent,
    DetailUtilisateurComponent,
    ModifUtilisateurComponent,
    UtilisateurFormComponent,
    AjoutUtilisateurComponent,
    SearchUtilisateurComponent,
    LoderComponent,
    
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule.forChild(utilisateurroutes),
    MatTabsModule
  ],
  providers: [UtilisateurService]
})
export class UtilisateurModule { }

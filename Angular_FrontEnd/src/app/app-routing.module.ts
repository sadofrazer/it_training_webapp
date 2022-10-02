import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './components/accueil/accueil.component';
import { AjoutUtilisateurComponent } from './modules/utilisateur/ajout-utilisateur/ajout-utilisateur.component';
import { DetailUtilisateurComponent } from './modules/utilisateur/detail-utilisateur/detail-utilisateur.component';
import { ListUtilisateurComponent } from './modules/utilisateur/list-utilisateur/list-utilisateur.component';
import { ModifUtilisateurComponent } from './modules/utilisateur/modif-utilisateur/modif-utilisateur.component';
import { ConnexionComponent } from './components/connexion/connexion.component';


const routes: Routes = [
{ path: 'accueil', component: AccueilComponent },
{path: 'formation',loadChildren:() => import('./modules/formation/formation.module').then(m => m.FormationModule) },
{path: 'session',loadChildren:() => import('./modules/session/session.module').then(m => m.SessionModule) },
{path: 'salle',loadChildren:() => import('./modules/salle/salle.module').then(m => m.SalleModule) },
{path: 'inscription',loadChildren:() => import('./modules/inscription/inscription.module').then(m => m.InscriptionModule) },
{ path: 'utilisateurs', component: ListUtilisateurComponent},
{ path: 'modif/utilisateur/:idUtilisateur', component:ModifUtilisateurComponent },
{ path: 'utilisateur/ajout', component: AjoutUtilisateurComponent},
{ path: 'utilisateur/:idUtilisateur', component: DetailUtilisateurComponent },
{ path: 'connexion', component: ConnexionComponent},
{ path: 'dashboard',loadChildren:() => import('./modules/dashboard/dashboard.module').then(m => m.DashboardModule) },
{ path: '**', redirectTo: '/accueil', pathMatch: 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

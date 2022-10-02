import { Component, OnInit } from '@angular/core';
import { Apprenant } from 'src/app/entities/Utilisateur/Apprenant';
import { Utilisateur } from 'src/app/entities/Utilisateur/utilisateur';


@Component({
  selector: 'app-ajout-utilisateur',
  template: `
    
    <div class="container-fluid full">
    <div class="row d-flex justify-content-center   align-items-center">
    <div class="text-center mt-4 mb-5">
        <span class="text-uppercase fst-italic text-wrap fs-4 own-title">
            Ajout
        </span>
    </div>
  <app-utilisateur-form  [utilisateur]="utilisateur"></app-utilisateur-form>
    </div>
    </div>

    

  `
 
})
export class AjoutUtilisateurComponent implements OnInit {

 utilisateur: Utilisateur;
 apprenant: Apprenant;

  ngOnInit(){
   this.utilisateur = new Utilisateur();
   this.apprenant = new Apprenant();
  
  }

}

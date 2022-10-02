import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Apprenant } from 'src/app/entities/Utilisateur/Apprenant';
import { Utilisateur } from 'src/app/entities/Utilisateur/utilisateur';
import { ApprenantService } from '../apprenant.service';

import { UtilisateurService } from '../utilisateur.service';

@Component({
  selector: 'app-modif-utilisateur',
  template: `
    <h2 class="center text-center">
     Modifier {{ utilisateur?.nom}}</h2>
    
    <app-utilisateur-form *ngIf="utilisateur" [utilisateur]="utilisateur" ></app-utilisateur-form>
    <app-utilisateur-form *ngIf="apprenant" [apprenant]="apprenant" ></app-utilisateur-form>

  `,
  styles: [
  ]
})
export class ModifUtilisateurComponent implements OnInit {

  utilisateur: Utilisateur|undefined;
  apprenant: Apprenant | undefined;

  constructor(private route: ActivatedRoute,
    private apprenantService: ApprenantService,
     private utilisateurService: UtilisateurService )  { }

  ngOnInit() {
    const utilisateurId: string|null = this.route.snapshot.paramMap.get('idUtilisateur');
    if(utilisateurId){
      /* sans observable
      this.utilisateur = this.utilisateurService.getutilisateurById(+utilisateurId);*/
      
      this.utilisateurService.getUtilisateurById(+utilisateurId).subscribe(utilisateur => this.utilisateur = utilisateur);

    }
    /*}else if(utilisateurId){
      this.apprenantService.getApprenantById(+utilisateurId).subscribe(apprenant => this.apprenant = apprenant);

    }*/
    else{
      this.utilisateur = undefined;
    }
  }

}

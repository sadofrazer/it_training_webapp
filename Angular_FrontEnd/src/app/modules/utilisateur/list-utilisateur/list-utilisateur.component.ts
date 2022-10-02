import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Apprenant } from 'src/app/entities/Utilisateur/Apprenant';
import { Formateur } from 'src/app/entities/Utilisateur/Formateur';
import { Responsable } from 'src/app/entities/Utilisateur/Responsable';
import { Utilisateur } from 'src/app/entities/Utilisateur/utilisateur';
import { ApprenantService } from '../apprenant.service';
import { FormateurService } from '../formateur.service';
import { ResponsableService } from '../responsable.service';
import { UtilisateurService } from '../utilisateur.service';


@Component({
  selector: 'app-list-utilisateur',
  templateUrl: './list-utilisateur.component.html',
 
  
})
export class ListUtilisateurComponent {

  utilisateurList: Utilisateur[];
  apprenantList: Apprenant[];
  formateurList: Formateur[];
  responsableList: Responsable[];
 


  constructor(private router: Router,
    private apprenantService: ApprenantService,
    private formateurService: FormateurService,
    private responsableService: ResponsableService,
     private utilisateurService: UtilisateurService){}

  ngOnInit(){
  

  this.utilisateurService.getUtilisateurList().subscribe(
     utilisateurList => this.utilisateurList = utilisateurList,
  );
 
  this.apprenantService.getApprenantList().subscribe(
    apprenantList => this.apprenantList = apprenantList,
 );
 this.formateurService.getFormateurtList().subscribe(
  formateurList => this.formateurList = formateurList,
);
this.responsableService.getResponsableList().subscribe(
  responsableList => this.responsableList = responsableList,
);
}

//methode d'affichage par id
  goToUtilisateur(utilisateur: Utilisateur){
    this.router.navigate(['utilisateur/',utilisateur.idUtilisateur])
  }
  goToApp(apprenant: Apprenant){
    this.router.navigate(['utilisateur/',apprenant.idUtilisateur])
  }
}

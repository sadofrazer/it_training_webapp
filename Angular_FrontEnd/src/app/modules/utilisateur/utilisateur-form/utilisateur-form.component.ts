import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Apprenant } from 'src/app/entities/Utilisateur/Apprenant';
import { Formateur } from 'src/app/entities/Utilisateur/Formateur';
import { Responsable } from 'src/app/entities/Utilisateur/Responsable';
import { TypeUser } from 'src/app/entities/Utilisateur/typeuser';
import { Utilisateur } from 'src/app/entities/Utilisateur/utilisateur';

import { ApprenantService } from '../apprenant.service';

import { FormateurService } from '../formateur.service';

import { ResponsableService } from '../responsable.service';

import { UtilisateurService } from '../utilisateur.service';

@Component({
  selector: 'app-utilisateur-form',
  templateUrl: './utilisateur-form.component.html',
  styleUrls: ['./utilisateur-form.component.scss']
   
  //styleUrls: ['./utilisateur-form.component.css']
  
})
export class UtilisateurFormComponent implements OnInit {
  @Input() utilisateur: Utilisateur;
  @Input() apprenant: Apprenant;
  @Input() formateur: Formateur;
  @Input() responsable: Responsable;
  affectation: TypeUser[];
  public af :TypeUser;
  isAddForm: boolean;
  isUpdate: boolean;

  constructor(private utilisateurService: UtilisateurService,
    private apprenantService: ApprenantService,
    private responsableService: ResponsableService,
     private formateurService: FormateurService, 
     private router: Router ) {}

  ngOnInit() {
    this.af = new TypeUser();
    this.apprenant = new Apprenant() ;
    this.formateur = new Formateur();
    this.responsable = new Responsable();;
   
   this.formateurService.getUtilisateurTypeList().subscribe((t:TypeUser[])=>{
     this.affectation = t;
     console.log(this.affectation);
   });
    this.isAddForm = this.router.url.includes('ajout');
    this.isUpdate = this.router.url.includes('modif');
  }
 


  onSubmit(){
    //met à jour le type de l'utilisateur avec l'objet type recu du ngmodel de notre select
    if(this.af){
      this.utilisateur.typeUser=this.af;
    }

    if(this.isAddForm && this.af.nom === 'FORMATEUR'){
      console.log(this.af);
      console.log(this.utilisateur);
      let form = <Formateur>this.utilisateur;
      form.certifications=this.formateur.certifications;
      this.formateurService.addFormateur(form).subscribe((formateur: Formateur) => this.router.navigate(['/utilisateurs']));

    }
    else if(this.isAddForm && this.af.nom === 'APPRENANT'){
       
      let app = <Apprenant>this.utilisateur;
      app.dernierDiplome=this.apprenant.dernierDiplome;

      this.apprenantService.addApprenant(app).subscribe((apprenant: Apprenant) => this.router.navigate(['/utilisateurs']));

    }
    else if(this.isAddForm && this.af.nom === 'Responsable'){
      console.log('admin')
      let admin = <Responsable>this.utilisateur;
      admin.fonction=this.responsable.fonction;
      console.log(admin);
      this.responsableService.addResponsable(admin).subscribe((responsable: Responsable) => this.router.navigate(['/utilisateurs']));

    }else if(this.isUpdate && this.af.nom === 'Apprenant'){
    
      this.apprenantService.updateApprenant(this.apprenant).subscribe(() => this.router.navigate(['/utilisateur', this.apprenant.idUtilisateur]));

    }
   
    
    else{
   
     this.utilisateurService.updateUtilisateur(this.utilisateur).subscribe(() => this.router.navigate(['/utilisateur', this.utilisateur.idUtilisateur]));

    }
  
   //this.router.navigate(['/Utilisateur', this.Utilisateur.id]);
  //}
  }}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ConnexionService } from 'src/app/components/connexion/connexion.service';
import { Inscription } from 'src/app/entities/Inscription/Inscription';

import { FormationService } from 'src/app/modules/formation/services/formation.service';
import { AttribSalle } from 'src/app/modules/salle/entities/AttribSalle';
import { AttribSalleService } from 'src/app/modules/salle/services/attrib-salle.service';
import { Session } from 'src/app/modules/session/entities/Session';
import { SessionService } from 'src/app/modules/session/services/session.service';
import {InscriptionService} from 'src/app/modules/inscription/services/inscription.service'
import { Apprenant } from 'src/app/entities/Utilisateur/Apprenant';
import { ApprenantService } from 'src/app/modules/utilisateur/apprenant.service';


@Component({
  selector: 'app-create-inscription',
  templateUrl: './create-inscription.component.html',
  styleUrls: ['./create-inscription.component.scss']
})
export class CreateInscriptionComponent implements OnInit {

  constructor(private formationService:FormationService, private sessionService: SessionService,
    private inscriptionService:InscriptionService, private attribSalleService: AttribSalleService,
    private connexionService: ConnexionService, private apprenantService:ApprenantService,
    private activatedRoute: ActivatedRoute,private router: Router) { }

  public session: Session;
  public inscription: Inscription;
  public apprenant : Apprenant;
  public id : number;
  public attribSalles: AttribSalle[]=[]; 
  public varOk:boolean=false;
  public appOk:boolean=false;
  public nbreMax: number = 0;

  ngOnInit(): void {

    //récupération de l'apprenant connecté à partir du Local Storage
    if(localStorage.getItem('type') && localStorage.getItem('type')){
      let typeUser = localStorage.getItem('type');
      let idUser = parseInt(localStorage.getItem('id'));
      if(typeUser=='APPRENANT'){
        console.log('Apprenant connecté')
        this.apprenantService.getApprenantById(idUser).subscribe((app:Apprenant)=>{
          if(app){
            this.apprenant=app;
            this.appOk=true;
            
          }
          console.log(this.apprenant);
        })
      }
    }
    

    //initialisation des variable
    this.apprenant=new Apprenant();
    this.inscription=new Inscription();

    //Activation du rafraichissement de la page
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;

    //récupération de l'ID dans l'URL
    const stringId: string = this.activatedRoute.snapshot.paramMap.get('id');
    this.id = stringId? parseInt(stringId):0;

    //Récupération de la session en fonction de l'ID passée dans l'URL
    this.sessionService.getSessionById(this.id? this.id:1).subscribe((s: Session)=>{
      this.session=s;
    })

    //on récupère les salles de la session en cours pour les ajouter à la liste des choix des salles (pour besoin de modification)
    this.attribSalleService.getAllBySessionId(this.id? this.id:1 ).subscribe((attribs:AttribSalle[])=>{
      this.attribSalles=attribs;
      this.varOk=true;
      for(let a of attribs){
        this.nbreMax +=a.salle.nbrePlaces; 
      }
      console.log('nbre de palces : ' + this.nbreMax);
    });

  }

  public addInscription():void{
    
    //assignation des valeurs à l'inscription
    this.inscription.session=this.session;
    this.inscription.statut='NEW';
    this.inscription.dateInscription=new Date();
    this.inscription.apprenant= this.apprenant;


    //insertion en BDD
    this.inscriptionService.addInscription(this.inscription).subscribe((i:Inscription)=>{
      if(i){
        console.log('Inscription ' + i.codeInscription + ' Ajoutée en BDD');
        this.router.navigate(['/inscription/lister/apprenant/'+i.apprenant.idUtilisateur])
      }
    })
  }

}
import { Component, OnInit,ElementRef, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Formation } from 'src/app/entities/Formation/formation';
import { Formateur } from 'src/app/entities/Utilisateur/Formateur';
import { FormationService } from 'src/app/modules/formation/services/formation.service';
import { AttribSalle } from 'src/app/modules/salle/entities/AttribSalle';
import { Salle } from 'src/app/modules/salle/entities/salle';
import { AttribSalleService } from 'src/app/modules/salle/services/attrib-salle.service';
import { SalleService } from 'src/app/modules/salle/services/salle.service';
import { Session } from '../../entities/Session';
import { SessionService } from '../../services/session.service';
import {COMMA, ENTER} from '@angular/cdk/keycodes';
import * as _ from 'lodash';

import {FormControl} from '@angular/forms';
import {MatAutocompleteSelectedEvent} from '@angular/material/autocomplete';
import {MatChipInputEvent} from '@angular/material/chips';
import { ConnexionService } from 'src/app/components/connexion/connexion.service';
import { FormateurService } from 'src/app/modules/utilisateur/formateur.service';


export interface Fruit {
  name: string;
}

@Component({
  selector: 'app-gestion-session',
  templateUrl: './gestion-session.component.html',
  styleUrls: ['./gestion-session.component.scss']
})


export class GestionSessionComponent implements OnInit {
  public session: Session;
  public sessions$ : Observable<Session[]>;
  public formations$: Observable<Formation[]>;
  public formateurs: Formateur[] = [];
  public salles : Salle[];
 // public attribSalle: AttribSalle;
  public selectFormateur: Formateur;
  public attribSalles: AttribSalle[]=[]; 

  private id : number;

  public isCreation:boolean =true;
  public varOk:boolean=false;
  public formOk:boolean=false;
  public varAttrib:boolean=false;
  public dateNow: Date;

  separatorKeysCodes: number[] = [ENTER, COMMA];
  fruitCtrl = new FormControl('');
  codeSalles: string[] = [];
  //allFruits: string[] = ['Apple', 'Lemon', 'Lime', 'Orange', 'Strawberry'];

  @ViewChild('salleInput') salleInput: ElementRef<HTMLInputElement>;



  constructor(private formationService:FormationService, private sessionService: SessionService,
    private salleService:SalleService, private attribSalleService: AttribSalleService,
    private connexionService: ConnexionService, private formateurService:FormateurService,
    private activatedRoute: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
    console.log(this.connexionService.pers)
    this.selectFormateur=new Formateur();
    this.selectFormateur=null;

    //récupération des formateurs
    this.formateurService.getFormateurtList().subscribe((f:Formateur[])=>{
      this.formateurs=f;
      this.formOk=true;
    })

    //this.attribSalle=new AttribSalle();
    this.dateNow = new Date();
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    const stringId: string = this.activatedRoute.snapshot.paramMap.get('id');
    this.id = stringId? parseInt(stringId):0;

    this.formations$=this.formationService.getAllFormations();
    this.sessions$ = this.sessionService.getAllSessions();

    //On récupère la liste des salles qui ont le statut "FREE"
    this.salleService.getFreeSalles().subscribe((s:Salle[])=>{
      this.salles=s;

      //On récupère tous les attrib salles présent en BDD
      this.attribSalleService.getAllAttribSalles().subscribe((a:AttribSalle[])=>{
        this.attribSalles=a;
        console.log(this.attribSalles)
        this.varAttrib=true
      })
      //On récupère la sesion correspondante à l'ID passé dans l'URL
      this.sessionService.getSessionById(this.id>0? this.id : 1).subscribe((s:Session)=>{
        this.session=s;
        this.codeExist(this.session.codeSession);

        //on récupère les salles de la session en cours pour les ajouter à la liste des choix des salles (pour besoin de modification)
        this.attribSalleService.getAllBySessionId(this.session.idSession).subscribe((attribs:AttribSalle[])=>{
          for (let a of attribs){
            this.salles.push(a.salle);
            console.log(this.salles)
          }
        });

      });

    });

  }


  public selectFormateurChange(e):void{
    let value : string = e.target.value;
    console.log(e.target.value);
    if(value=="null"){
      this.session.formateur=null;
      this.selectFormateur=null;
    }
    console.log(this.selectFormateur);
  }

  public selectFormationChange(e):void{
    let value : string = e.target.value;
    console.table(e.target.value);
    console.log(value.split("-",1));
    this.formationService.searchFormByWord(value.split("-",1)[0]).subscribe((fs: Formation[])=>{
      if (fs.length>0){
        this.session.formation=fs[0];
        console.log(this.session.formation)
      }
    })
  }

  /*public selectSalleChange(e):void{
    let value : string = e.target.value;
    console.table(e.target.value);
    console.log(value.split("-",1));
    this.salleService.getSalleByCode(value.split("-",1)[0]).subscribe((s: Salle)=>{
      this.attribSalle.salle=s;
    })
  }*/

  public changeId(e):void{
    this.codeExist(e.target.value);
  }

  public codeExist(code:string):void{
    this.sessionService.CodeSessionExist(code).subscribe((b: Boolean)=>{
      if(b){
        //On récupère la liste des salles qui ont le statut "FREE"
        this.salleService.getFreeSalles().subscribe((s:Salle[])=>{
          this.salles=s;
          //on ajoute à ces salles celles de la session
          this.sessionService.getSessionByCode(code).subscribe((s:Session)=>{
            //on récupère les salles de la session en cours pour les ajouter à la liste des choix des salles (pour besoin de modification)
            this.attribSalleService.getAllBySessionId(s.idSession).subscribe((attribs:AttribSalle[])=>{
              for (let a of attribs){
                this.salles.push(a.salle);
                console.log(this.salles)
              }
            });
          })
        });

        this.isCreation=false;
        this.varOk=true;
      }else{
        this.isCreation=true;
        this.varOk=true;

        //On réinitilaise la liste des salles qui ont le statut "FREE"
        this.salleService.getFreeSalles().subscribe((s:Salle[])=>{
          this.salles=s;
        });
      }
      console.log(this.isCreation);
    })
      
  }

  public addUpdateSession() : void{
    console.log(this.codeSalles);

    //créer une liste de code salles sélectionnées.
    let tab: string[]=[];
    for(let s1 of this.codeSalles){
      tab.push(s1.split("-",1)[0]);
    }

    //création de la liste de salles
    let selectSalles : Salle[]= [];
    let listSallesOk:boolean = false;
    for(let s of tab){
      this.salleService.getSalleByCode(s).subscribe((salle : Salle)=>{
        if(!selectSalles.find(x=> x.idSalle==salle.idSalle)){
          selectSalles.push(salle);
        }
        listSallesOk=true;
      })
    }
    if (tab.length<=0){
      listSallesOk=true;
    }

    //Si c'est une création...
    if(this.isCreation){
      this.session.idSession=0;
      this.session.statut="PLAN";
      this.session.formateur=this.selectFormateur;
      console.log(this.session);
      this.sessionService.addSession(this.session).subscribe((s: Session)=>{
        this.session=s;

        do{
          console.log("On patiente le temps d'avoir la liste des salles de l'observable (asynchrone)");
          console.log(listSallesOk);
        }while(!listSallesOk)

        //récupération des salles sélectionnées dans une liste et création des différentes attributions de salles dans la BDD
        for(let salle of selectSalles){
          let attrib : AttribSalle = new AttribSalle();
          attrib.idAttribSalle=0;
          attrib.dateAttrib=this.dateNow;
          attrib.dateModif=this.dateNow;
          attrib.salle=salle;
          attrib.session=this.session
          attrib.statut="ACTIVE"
          console.log(attrib);
          //pour chaque salle on crée l'enregistrement d'attribution liée à la session
          this.attribSalleService.addAttribSalle(attrib).subscribe((b:Boolean)=>{
            //console.log(b);
              //Après avoir affécté les salles à cette session, on modifie le statut desdites salles afin qu'elles ne puissent plus etre réallouées
              if(b){
              salle.statut="RESERVED"
              this.salleService.editSalle(salle.idSalle, salle).subscribe();
              }
          });
            
        }
        this.router.navigate(['/session/gestion/'+this.session.idSession]);
        
      });
      
    }else{
      if(this.id>0){

        console.log("execute update")
        this.sessionService.editSession(this.id, this.session).subscribe((s:Session)=>{
          this.session=s;

          //Scénario de modification
          do{
            console.log("On patiente le temps d'avoir la liste des salles de l'observable (asynchrone)");
            console.log(listSallesOk);
          }while(!listSallesOk)

          //On récupère la liste ses attrib salle de la session en question afin de les modifier
          this.attribSalleService.getAllBySessionId(this.session.idSession).subscribe((a : AttribSalle[])=>{

            //une fois la liste récupérée, on boucle ses élements afin de réaliser les éventuelles modifs
            for(let attrib of a){
              attrib.statut="INACTIVE"
              this.attribSalleService.editAttribSalle(attrib.idAttribSalle,attrib).subscribe();

              //on libère également les différentes salles liées à ces attributions
              attrib.salle.statut="FREE";
              this.salleService.editSalle(attrib.salle.idSalle, attrib.salle).subscribe();
            }
            //après avoir passé ces attribution à INACTIVE afin de garder l'historique, on en crée de nouvelles
    
            //récupération des salles sélectionnées dans une liste et création des différentes attributions de salles dans la BDD
            for(let salle of selectSalles){
              let attrib : AttribSalle = new AttribSalle();
              attrib.idAttribSalle=0;
              if(!attrib.dateAttrib) attrib.dateAttrib=this.dateNow;
              attrib.dateModif=this.dateNow;
              attrib.salle=salle;
              attrib.session=this.session
              attrib.statut="ACTIVE"
              console.log(attrib);
              //pour chaque salle on crée l'enregistrement d'attribution liée à la session
              this.attribSalleService.addAttribSalle(attrib).subscribe((b:Boolean)=>{
                //console.log(b);
                  //Après avoir affécté les salles à cette session, on modifie le statut desdites salles afin qu'elles ne puissent plus etre réallouées
                  if(b){
                  salle.statut="RESERVED"
                  this.salleService.editSalle(salle.idSalle, salle).subscribe();
                  }
              });
                
            }

          })

          this.router.navigate(['/session/gestion/'+s.idSession]);

        });
       
      }
    }

  }


  public deleteSession(id: number):void{
    let delOk:number=1;
    //suppression des attributions de salles, libération des salles avant de supprimer les sessions
    this.attribSalleService.getAllBySessionId(id).subscribe((attribs: AttribSalle[])=>{
      delOk=attribs.length;
      for(let a of attribs){
        a.salle.statut="FREE"
        this.salleService.editSalle(a.salle.idSalle, a.salle).subscribe();
        this.attribSalleService.deleteAttribSalle(a.idAttribSalle).subscribe((b1:boolean)=>{
          if(b1){
            
          }
        });
      }
    });

    let delSession : boolean = false
    this.sessionService.deleteSession(id).subscribe((b:boolean)=>{
      delSession=b;
      if(b){
        delSession=true
        this.router.navigate(['/session/gestion/']).then(() => {
          window.location.reload();
        });
      }else{
        this.sessionService.deleteSession(id).subscribe((b2:boolean)=>{
          if(b2){
            delSession=true;
            this.router.navigate(['/session/gestion/']).then(() => {
              window.location.reload();
            });
          }
        });
      }
    })
  }





  add(event: MatChipInputEvent): void {
    const value = (event.value || '').trim();
    // Add our Salle
    if (value) {
        this.codeSalles.push(value)
        console.log(this.codeSalles);
    }
    console.log(this.codeSalles);
    // Clear the input value
    event.chipInput!.clear();
    this.fruitCtrl.setValue(null);
  }

  remove(salle: string): void {
    const index = this.codeSalles.indexOf(salle);

    if (index >= 0) {
      this.codeSalles.splice(index, 1);
    }
    
  }

  selected(event: MatAutocompleteSelectedEvent): void {
    this.codeSalles.push(event.option.viewValue);
    this.salleInput.nativeElement.value = '';
    this.fruitCtrl.setValue(null);
  }

  /*private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.allFruits.filter(fruit => fruit.toLowerCase().includes(filterValue));
  }*/

}

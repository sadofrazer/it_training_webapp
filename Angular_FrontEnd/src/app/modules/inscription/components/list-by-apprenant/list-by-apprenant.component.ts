import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Inscription } from 'src/app/entities/Inscription/Inscription';
import { Apprenant } from 'src/app/entities/Utilisateur/Apprenant';
import { ApprenantService } from 'src/app/modules/utilisateur/apprenant.service';
import { InscriptionService } from '../../services/inscription.service';

@Component({
  selector: 'app-list-by-apprenant',
  templateUrl: './list-by-apprenant.component.html',
  styleUrls: ['./list-by-apprenant.component.scss']
})

export class ListByApprenantComponent implements OnInit {

  public inscription:Inscription;
  public inscriptions$ : Observable<Inscription[]>
  public varOk:boolean=false;
  public appOk:boolean=false;
  private id : number;
  private apprenant:Apprenant;

  constructor(private inscriptionService:InscriptionService, private apprenantService:ApprenantService,
    private activatedRoute: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {

    this.apprenant=new Apprenant();
    this.inscription=new Inscription;
    const stringId: string = this.activatedRoute.snapshot.paramMap.get('id');
    this.id = stringId? parseInt(stringId):0;

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
          this.inscriptions$ = this.inscriptionService.getAllByApprenant(this.id? this.id:this.apprenant.idUtilisateur);
          //console.log(this.apprenant);
        })
      }
    }
  }

}

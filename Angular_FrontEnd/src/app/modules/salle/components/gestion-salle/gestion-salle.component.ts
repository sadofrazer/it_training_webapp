import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Salle } from '../../entities/salle';
import { SalleService } from '../../services/salle.service';

@Component({
  selector: 'app-gestion-salle',
  templateUrl: './gestion-salle.component.html',
  styleUrls: ['./gestion-salle.component.scss']
})
export class GestionSalleComponent implements OnInit {

  public salles$ : Observable<Salle[]>;
  public salle: Salle
  public rue:string;
  public codePost:string;
  public isCreation:boolean =true;
  public varOk:boolean = false;
  private id : number;

  constructor(private salleService: SalleService, private activatedRoute: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    const stringId: string = this.activatedRoute.snapshot.paramMap.get('id');
    this.id = stringId? parseInt(stringId):0;

    this.salles$ = this.salleService.getAllSalles();
    
    this.salleService.getSalleById(this.id>0? this.id : 1).subscribe((s: Salle)=>{
      this.salle=s;
      let address = this.salle.adresse.split("-",2);
      console.log(address);
      this.rue=address[0];
      this.codePost=address[1];
      this.codeExist(s.codeSalle);
    });
    

  }


  public changeId(e):void{
    this.codeExist(e.target.value);
  }

  public codeExist(code:string):void{
    this.salleService.CodeSalleExist(code).subscribe((b: Boolean)=>{
      if(b){
        this.isCreation=false;
        this.varOk=true;
      }else{
        this.isCreation=true;
        this.varOk=true;
      }
    })
      
  }

  public addUpdateSalle() : void{
    if (this.rue && this.codePost){
      this.salle.adresse=this.rue + "-" + this.codePost;
    }
    if(this.isCreation){
      this.salle.idSalle=0;
      this.salle.statut="FREE";
      this.salleService.addSalle(this.salle).subscribe((s: Salle)=>{
        this.salle=s;
        this.router.navigate(['/salle/gestion/'+this.salle.idSalle]);
      });
      
    }else{
      if(this.id>0){
        console.log("execute update")
        this.salleService.editSalle(this.id, this.salle).subscribe((s:Salle)=>{
          this.salle=s;
          this.router.navigate(['/salle/gestion/1']);
        });
      }
    }
  }


  public deleteSalle(id: number):void{
    this.salleService.deleteSalle(id).subscribe((b:boolean)=>{
      if(b){
        this.router.navigate(['/salle/gestion/']);
      }
    })
  }
  
}

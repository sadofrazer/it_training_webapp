import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { FormationService } from 'src/app/modules/formation/services/formation.service';
import { AttribSalle } from 'src/app/modules/salle/entities/AttribSalle';
import { AttribSalleService } from 'src/app/modules/salle/services/attrib-salle.service';
import { SalleService } from 'src/app/modules/salle/services/salle.service';
import { Session } from '../../entities/Session';
import { SessionService } from '../../services/session.service';

@Component({
  selector: 'app-list-session-by-formation',
  templateUrl: './list-session-by-formation.component.html',
  styleUrls: ['./list-session-by-formation.component.scss']
})
export class ListSessionByFormationComponent implements OnInit {

  public sessions$ : Observable<Session[]>;
  public attribSalles: AttribSalle[]=[]; 
  public varOk:boolean=false;
  public varAttrib:boolean=false;

  private id : number;
  
  constructor(private formationService:FormationService, private sessionService: SessionService,
    private salleService:SalleService, private attribSalleService: AttribSalleService,
    private activatedRoute: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {

    const stringId: string = this.activatedRoute.snapshot.paramMap.get('id');
    this.id = stringId? parseInt(stringId):0;

    //On récupère les sessions
    this.sessions$ = this.sessionService.getSessionByFormation(this.id>0? this.id : 1);


    //On récupère tous les attrib salles présent en BDD
    this.attribSalleService.getAllAttribSalles().subscribe((a:AttribSalle[])=>{
      this.attribSalles=a;
      console.log(this.attribSalles)
      this.varAttrib=true
    })

  }

}

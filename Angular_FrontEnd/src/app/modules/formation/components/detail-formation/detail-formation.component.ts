import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Formation } from 'src/app/entities/Formation/formation';
import { FormationService } from '../../services/formation.service';
import { SthemeService } from '../../services/stheme.service';

@Component({
  selector: 'app-detail-formation',
  templateUrl: './detail-formation.component.html',
  styleUrls: ['./detail-formation.component.scss']
})
export class DetailFormationComponent implements OnInit {
  private id : number;
  public formation$ : Observable<Formation>;
  constructor(private formationService:FormationService, private sthemeService: SthemeService, private activatedRoute: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
    const stringId: string = this.activatedRoute.snapshot.paramMap.get('id');
    this.id = stringId? parseInt(stringId):0;
    this.formation$=this.formationService.getFormById(this.id);
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
  }

}

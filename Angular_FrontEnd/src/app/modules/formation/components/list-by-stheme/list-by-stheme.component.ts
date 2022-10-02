import { Component, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Formation } from 'src/app/entities/Formation/formation';
import { Stheme } from 'src/app/entities/Formation/sous-theme';
import { FormationService } from '../../services/formation.service';
import { SthemeService } from '../../services/stheme.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Theme } from 'src/app/entities/Formation/theme';
import { ThemeService } from '../../services/theme.service';

@Component({
  selector: 'app-list-by-theme',
  templateUrl: './list-by-stheme.component.html',
  styleUrls: ['./list-by-stheme.component.scss']
})
export class ListBySthemeComponent implements OnInit {
  private id : number;
  public sthemes$: Observable<Stheme[]>;
  public formation$ : Observable<Formation[]>;
  public theme$: Observable<Theme>;

  constructor(private themeService:ThemeService, private formationService:FormationService, private sthemeService: SthemeService, private activatedRoute: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
    const stringId: string = this.activatedRoute.snapshot.paramMap.get('id');
    this.id = stringId? parseInt(stringId):0;
    this.theme$=this.themeService.getSthemeById(this.id);
    this.sthemes$=this.sthemeService.getSthemeByTheme(this.id);
    this.formation$=this.formationService.getFormByTheme(this.id);
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
  }

  public listSthemeByTheme(): void{
    this.sthemes$=this.sthemeService.getSthemeByTheme(this.id);
    this.formation$=this.formationService.getFormByTheme(this.id);
    this.router.navigate([`/formation/lister/${this.id}`]);
  }

  public listFormByStheme(): Observable<Formation[]> {
    return this.formationService.getFormByStheme(this.id);
    
  }

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Formation } from 'src/app/entities/Formation/formation';
import { Stheme } from 'src/app/entities/Formation/sous-theme';
import { Theme } from 'src/app/entities/Formation/theme';
import { SearchService } from 'src/app/services/search.service';
import { FormationService } from '../../services/formation.service';
import { SthemeService } from '../../services/stheme.service';
import { ThemeService } from '../../services/theme.service';

@Component({
  selector: 'app-list-formation',
  templateUrl: './list-by-theme.component.html',
  styleUrls: ['./list-by-theme.component.scss']
})
export class ListByThemeComponent implements OnInit {

  public sthemes$: Observable<Stheme[]>;
  public formations$ : Observable<Formation[]>;
  public themes$ : Observable<Theme[]>;
  constructor(private themeService:ThemeService, private formationService:FormationService, 
    private sthemeService: SthemeService, private activatedRoute: ActivatedRoute,private router: Router,
    private searchService:SearchService) { }

  ngOnInit(): void {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.themes$=this.themeService.getAllThemes();
    this.sthemes$=this.sthemeService.getAllSthemes();
    this.formations$=this.formationService.getAllFormations();
  }

}

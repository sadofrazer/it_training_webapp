import { Component, OnDestroy, OnInit } from '@angular/core';
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
  selector: 'app-catalogue',
  templateUrl: './catalogue.component.html',
  styleUrls: ['./catalogue.component.scss']
})
export class CatalogueComponent implements OnInit, OnDestroy {

  public formations$ : Observable<Formation[]>;
  public word : string = null;

  constructor(private formationService:FormationService, 
    private activatedRoute: ActivatedRoute,private router: Router,
    private searchService:SearchService) { }


  ngOnDestroy(): void {
    //this.searchService.word=null;
  }

  ngOnInit(): void {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    //console.log(this.word);
    this.word=this.searchService.word;

    if(this.searchService.word!=null){
      this.formations$=this.formationService.searchFormByWord(this.searchService.word)
      this.formationService.searchFormByWord(this.searchService.word).subscribe((f:Formation[])=>{
        console.log(f);
        console.log(this.searchService.word)
      });
    }else{
      this.formations$=this.formationService.getAllFormations();
    }
  }

}

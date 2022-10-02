import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { debounceTime, distinctUntilChanged, Observable, Subject, switchMap } from 'rxjs';
import { Utilisateur } from 'src/app/entities/Utilisateur/utilisateur';

import { UtilisateurService } from '../utilisateur.service';

@Component({
  selector: 'app-search-utilisateur',
  templateUrl: './search-utilisateur.component.html',
  styles: [
  ]
})
export class SearchUtilisateurComponent implements OnInit {
  searchTerms = new Subject<string>();
  utilisateurs$: Observable<Utilisateur[]>;

  constructor(private router: Router, private utilisateurSerivice: UtilisateurService) { }

  ngOnInit(): void {
    this.utilisateurs$ = this.searchTerms.pipe(
     debounceTime(300),
     distinctUntilChanged(),
     switchMap((term) => this.utilisateurSerivice.searchUtilasteurList(term))

    );
  }

  search(terme: string){
   this.searchTerms.next(terme);
  }

  goToDetail(utilisateur: Utilisateur){
    const link = ['/utilisateur', utilisateur.idUtilisateur];
    this.router.navigate(link);
  }

}

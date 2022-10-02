import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Utilisateur } from 'src/app/entities/Utilisateur/utilisateur';
import { ConnexionService } from './connexion.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent implements OnInit {
  
  private utilisateur = new Utilisateur();
  public login: string;
  public password: string;
  erreur = 0;

  constructor(private connexionService : ConnexionService, private router: Router) { }

  ngOnInit(): void {
  }
  
  seConnecter(): void{
    this.connexionService.getPersonneByLoginAndMotDePasse(this.login, this.password).subscribe({
      next: utilisateur => {
        this.utilisateur = utilisateur
        if(utilisateur!=null){
          console.log(utilisateur);
          localStorage.setItem('id', String(utilisateur.idUtilisateur));
          localStorage.setItem('login',utilisateur.login);
          localStorage.setItem('type',utilisateur.typeUser.nom);
          localStorage.setItem('connexion','true');
          this.router.navigate(['/']);
        }else{
        this.erreur = 1;
        }
      }
    }); 
  }  
}

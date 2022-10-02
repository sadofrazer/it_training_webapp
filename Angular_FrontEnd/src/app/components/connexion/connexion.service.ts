import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, Observable, of, throwError } from 'rxjs';
import { FORMATION_API_URL } from 'src/app/entities/Formation/formation';
import { Utilisateur } from 'src/app/entities/Utilisateur/utilisateur';


@Injectable({
  providedIn: 'root'
})
export class ConnexionService {

  private readonly PERSONNE_API_URL = `${FORMATION_API_URL}/connexion/`;

  public personne = new Utilisateur();
  public login: string;
  public isloggedIn: boolean = false;
  public type: string;
  public pers = new Utilisateur();

  constructor(private http: HttpClient, private router: Router) { }

  public getPersonneByLoginAndMotDePasse(login: string, mot: string): Observable<Utilisateur> {
    const url = `${this.PERSONNE_API_URL}/${login}/${mot}`;
    return this.http.get<Utilisateur>(url).pipe(
      catchError(this.handleError)
    );
  }

  seDeconnecter(){
    localStorage.clear();
    this.pers=null;
    this.router.navigate(['/']);
  }

  isConnected(){
    let connected = localStorage.getItem('connexion');
    if(connected == 'true'){
      return true;
    }else{
      return false;
    }
  }

  isResponsable(){
    let role = localStorage.getItem('type');
    if(role==='Responsable'){
      return true;
    }else{
      return false;
    }
  }

  isApprenant(){
    let role = localStorage.getItem('type');
    if(role==='APPRENANT'){
      return true;
    }else{
      return false;
    }
  }

  isFormateur(){
    let role = localStorage.getItem('type');
    if(role==='FORMATEUR'){
      return true;
    }else{
      return false;
    }
  }

  isAdministrateur(){
    let role = localStorage.getItem('type');
    if(role==='Administrateur'){
      return true;
    }else{
      return false;
    }
  }

  setLoggedUserFromLocalStorage(login : string, type : string){
    localStorage.setItem('login',login);
    localStorage.setItem('type',type);
    this.isloggedIn = true;
  }
  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    return throwError(
      'Something bad happened; please try again later.');
  }
}
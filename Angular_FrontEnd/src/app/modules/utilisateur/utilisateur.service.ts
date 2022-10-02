import { Injectable } from '@angular/core';
import { catchError, Observable, tap, of } from 'rxjs';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Utilisateur, UTILISATEUR_API_URL } from 'src/app/entities/Utilisateur/utilisateur';
import { Apprenant } from 'src/app/entities/Utilisateur/Apprenant';
import { TypeUser } from 'src/app/entities/Utilisateur/typeuser';



@Injectable({
  providedIn: 'root'
})
//
export class UtilisateurService {
   APIUSER ='${UTILISATEUR_API_URL}/utilisateurs';
   LASTAPIUSER = 'http://localhost:8080/UtilisateurRestApi/rest/utilisateurs';
   APITYPE = `${UTILISATEUR_API_URL}/typeuser`;

  constructor (private http: HttpClient){

   }
   getUtilisateurList(): Observable<Utilisateur[]>{
    return this.http.get<Utilisateur[]>(this.APIUSER).pipe(
     tap((respose)=> this.log(respose)),
     catchError((error)=> this.mesErrors(error,[]))
    );
   }
  
   getUtilisateurById(utilisateurId: number): Observable<Utilisateur|undefined>{
    return this.http.get<Utilisateur>(`${UTILISATEUR_API_URL}/utilisateurs/${utilisateurId}`).pipe(
      tap((respose)=> this.log(respose)),
      catchError((error)=> this.mesErrors(error,undefined))
      );
  }
  updateUtilisateur(utilisateur: Utilisateur): Observable<null>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    };

    return this.http.put(this.LASTAPIUSER, utilisateur, httpOptions).pipe(
      tap((respose)=> this.log(respose)),
      catchError((error)=> this.mesErrors(error,null))
      );
    
  }
  updateApprenant(apprenant: Apprenant): Observable<null>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    };

    return this.http.put(this.LASTAPIUSER, apprenant, httpOptions).pipe(
      tap((respose)=> this.log(respose)),
      catchError((error)=> this.mesErrors(error,null))
      );
    
  }
  deleteUtilisateurById(utilisateurId: number): Observable<null>{
     return this.http.delete(`${UTILISATEUR_API_URL}/utilisateurs/${utilisateurId}`).pipe(
      tap((respose)=> this.log(respose)),
      catchError((error)=> this.mesErrors(error,null))
      );
     
  }
  addUtilisateur(utilisateur: Utilisateur): Observable<Utilisateur>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    };

    return this.http.post<Utilisateur>(this.LASTAPIUSER, utilisateur, httpOptions).pipe(
      tap((respose)=> this.log(respose)),
      catchError((error)=> this.mesErrors(error,null))
      );
    
  }
  
  searchUtilasteurList(term: string): Observable<Utilisateur[]>{
    if(term.length <=1){
      return of ([]);
    }
    return this.http.get<Utilisateur[]>(`${UTILISATEUR_API_URL}/utilisateurs/?nom=${term}`).pipe(
      tap((respose)=> this.log(respose)),
      catchError((error)=> this.mesErrors(error, []))
      );
  }
  // methode de foctorisaton du code utilisable juste ici
  private log(respose:any){
   console.table(respose);
  }
private mesErrors(error: Error, errorValue: any){
  console.error(error);
  return of(errorValue);
}
 /* on retoune un constante synchone 
  getUtilisateurList(): Utilisateur[]{
    return UtilisateurS;
  }*/
/* pareille ^
  getUtilisateurById(UtilisateurId: number): Utilisateur|undefined{
    return UtilisateurS.find(Utilisateur => Utilisateur.id == UtilisateurId);
  }*/

  getUtilisateurTypeList(): Observable<TypeUser[]>{
  
    return this.http.get<TypeUser[]>(this.APITYPE).pipe(
      tap((respose)=> this.log(respose)),
      catchError((error)=> this.mesErrors(error, []))
      );
  }
}

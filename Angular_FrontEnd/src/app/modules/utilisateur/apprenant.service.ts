import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError, Observable, tap, of } from "rxjs";
import { Apprenant } from "src/app/entities/Utilisateur/Apprenant";
import { TypeUser } from "src/app/entities/Utilisateur/typeuser";
import { UTILISATEUR_API_URL } from "src/app/entities/Utilisateur/utilisateur";




@Injectable({
    providedIn: 'root'
  })
  //${UTILISATEUR_API_URL}/utilisateur
  export class ApprenantService {
  APIAPP =`${UTILISATEUR_API_URL}/apprenants`;
  LASTAPIAPP = 'http://localhost:8080/UtilisateurRestApi/rest/apprenants';
  APITYPE = `${UTILISATEUR_API_URL}/typeuser`
  
    constructor (private http: HttpClient){
    
     }
    
     
     getApprenantList(): Observable<Apprenant[]>{
      return this.http.get<Apprenant[]>(this.APIAPP).pipe(
       tap((respose)=> this.log(respose)),
       catchError((error)=> this.mesErrors(error,[]))
      );
     }
     getApprenantById(utilisateurId: number): Observable<Apprenant|undefined>{
      return this.http.get<Apprenant>(`${UTILISATEUR_API_URL}/apprenants/${utilisateurId}`).pipe(
        tap((respose)=> this.log(respose)),
        catchError((error)=> this.mesErrors(error,undefined))
        );
    }
    updateApprenant(apprenant: Apprenant): Observable<null>{
      const httpOptions = {
        headers: new HttpHeaders({'Content-Type': 'application/json'})
      };
  
      return this.http.put(this.APIAPP, apprenant, httpOptions).pipe(
        tap((respose)=> this.log(respose)),
        catchError((error)=> this.mesErrors(error,null))
        );
      
    }
    
    deleteUtilisateurById(utilisateurId: number): Observable<null>{
       return this.http.delete(`${UTILISATEUR_API_URL}/apprenants/${utilisateurId}`).pipe(
        tap((respose)=> this.log(respose)),
        catchError((error)=> this.mesErrors(error,null))
        );
       
    }
    addApprenant(apprenant: Apprenant): Observable<Apprenant>{
      const httpOptions = {
        headers: new HttpHeaders({'Content-Type': 'application/json'})
      };
  
      return this.http.post<Apprenant>(this.APIAPP, apprenant, httpOptions).pipe(
        tap((respose)=> this.log(respose)),
        catchError((error)=> this.mesErrors(error,null))
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
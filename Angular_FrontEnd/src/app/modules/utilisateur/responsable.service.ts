import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError, Observable, tap, of } from "rxjs";
import { Responsable } from "src/app/entities/Utilisateur/Responsable";
import { TypeUser } from "src/app/entities/Utilisateur/typeuser";
import { UTILISATEUR_API_URL } from "src/app/entities/Utilisateur/utilisateur";




@Injectable({
    providedIn: 'root'
  })
  //${UTILISATEUR_API_URL}/utilisateur
  export class ResponsableService {
  APIRESP = `${UTILISATEUR_API_URL}/responsables`
   LASTAPIRESP = 'http://localhost:8080/UtilisateurRestApi/rest/responsables';
   APITYPE = `${UTILISATEUR_API_URL}/typeuser`;
    constructor (private http: HttpClient){
  
     }
    
     
     getResponsableList(): Observable<Responsable[]>{
      return this.http.get<Responsable[]>(this.APIRESP).pipe(
       tap((respose)=> this.log(respose)),
       catchError((error)=> this.mesErrors(error,[]))
      );
     }
     getResponsableById(utilisateurId: number): Observable<Responsable|undefined>{
      return this.http.get<Responsable>(`${UTILISATEUR_API_URL}/responsables/${utilisateurId}`).pipe(
        tap((respose)=> this.log(respose)),
        catchError((error)=> this.mesErrors(error,undefined))
        );
    }
    updateResponsable(responsable: Responsable): Observable<null>{
      const httpOptions = {
        headers: new HttpHeaders({'Content-Type': 'application/json'})
      };
  
      return this.http.put(this.APIRESP, responsable, httpOptions).pipe(
        tap((respose)=> this.log(respose)),
        catchError((error)=> this.mesErrors(error,null))
        );
      
    }
    
    deleteUtilisateurById(utilisateurId: number): Observable<null>{
       return this.http.delete(`${UTILISATEUR_API_URL}/responsables/${utilisateurId}`).pipe(
        tap((respose)=> this.log(respose)),
        catchError((error)=> this.mesErrors(error,null))
        );
       
    }
    addResponsable(responsable: Responsable): Observable<Responsable>{
      const httpOptions = {
        headers: new HttpHeaders({'Content-Type': 'application/json'})
      };
  
      return this.http.post<Responsable>(this.APIRESP, responsable, httpOptions).pipe(
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
  
  
    getUtilisateurTypeList(): Observable<TypeUser[]>{
    
      return this.http.get<TypeUser[]>(this.APITYPE).pipe(
        tap((respose)=> this.log(respose)),
        catchError((error)=> this.mesErrors(error, []))
        );
    }
  }
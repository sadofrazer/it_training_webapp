import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { FORMATION_API_URL } from 'src/app/entities/Formation/formation';
import { Salle } from '../entities/salle';

@Injectable({
  providedIn: 'root'
})
export class SalleService {
  constructor(private http: HttpClient) { }

  private static readonly _apiUrl = `${FORMATION_API_URL}/salle`;

  public getAllSalles() : Observable<Salle[]>{
    return this.http.get<Salle[]>(`${SalleService._apiUrl}`).pipe(
      catchError(this.handleError)
    );
  }

  public getFreeSalles() : Observable<Salle[]>{
    return this.http.get<Salle[]>(`${SalleService._apiUrl}/free`).pipe(
      catchError(this.handleError)
    );
  }

  public addSalle(s: Salle) : Observable<Salle>{
    console.log("execute add")
    return this.http.post<Salle>(`${SalleService._apiUrl}`,s).pipe(
      catchError(this.handleError)
    );
  }



  public editSalle(id:number, s:Salle) : Observable<Salle>{
    return this.http.put<Salle>(`${SalleService._apiUrl}/${id}`,s).pipe(
      catchError(this.handleError)
    );
  }


  public deleteSalle(id:number): Observable<boolean>{
    return this.http.delete<boolean>(`${SalleService._apiUrl}/${id}`).pipe(
      catchError(this.handleError)
    );
  }


  public getSalleById(id:number) : Observable<Salle>{
    return this.http.get<Salle>(`${SalleService._apiUrl}/${id}`).pipe(
      catchError(this.handleError)
    );
  }



  public getSalleByCode(code : string) : Observable<Salle>{
    return this.http.get<Salle>(`${SalleService._apiUrl}/search?code=${code}`).pipe(
      catchError(this.handleError)
    );
  }


  public CodeSalleExist(code : string) : Observable<Boolean>{
    return this.http.get<Boolean>(`${SalleService._apiUrl}/exist?code=${code}`).pipe(
      catchError(this.handleError)
    );
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
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }
  
}

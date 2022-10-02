import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { FORMATION_API_URL } from 'src/app/entities/Formation/formation';
import { AttribSalle } from '../entities/AttribSalle';

@Injectable({
  providedIn: 'root'
})
export class AttribSalleService {
  
  constructor(private http: HttpClient) { }

  private static readonly _apiUrl = `${FORMATION_API_URL}/attribSalle`;

  public getAllAttribSalles() : Observable<AttribSalle[]>{
    return this.http.get<AttribSalle[]>(`${AttribSalleService._apiUrl}`).pipe(
      catchError(this.handleError)
    );
  }


  public addAttribSalle(s: AttribSalle) : Observable<Boolean>{
    console.log("execute add")
    return this.http.post<Boolean>(`${AttribSalleService._apiUrl}`,s).pipe(
      catchError(this.handleError)
    );
  }



  public editAttribSalle(id:number, s:AttribSalle) : Observable<AttribSalle>{
    return this.http.put<AttribSalle>(`${AttribSalleService._apiUrl}/${id}`,s).pipe(
      catchError(this.handleError)
    );
  }


  public deleteAttribSalle(id:number): Observable<boolean>{
    return this.http.delete<boolean>(`${AttribSalleService._apiUrl}/${id}`).pipe(
      catchError(this.handleError)
    );
  }


  public getAttribSalleById(id:number) : Observable<AttribSalle>{
    return this.http.get<AttribSalle>(`${AttribSalleService._apiUrl}/${id}`).pipe(
      catchError(this.handleError)
    );
  }


  public getAllBySessionId(id:number) : Observable<AttribSalle[]>{
    return this.http.get<AttribSalle[]>(`${AttribSalleService._apiUrl}/session/${id}`).pipe(
      catchError(this.handleError)
    );
  }


  public getAllBySalleId(id:number) : Observable<AttribSalle[]>{
    return this.http.get<AttribSalle[]>(`${AttribSalleService._apiUrl}/salle/${id}`).pipe(
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

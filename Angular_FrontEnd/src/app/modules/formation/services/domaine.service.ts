import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Domaine } from 'src/app/entities/Formation/domaine';
import { FORMATION_API_URL } from 'src/app/entities/Formation/formation';

@Injectable({
  providedIn: 'root'
})

export class DomaineService {
  private _domaines: Domaine[] = [];
  constructor( private http: HttpClient) { }
  private static readonly _apiUrl = `${FORMATION_API_URL}/domaine`;



  public getAllFormations(): Observable<Domaine[]>{
    return this.http.get<Domaine[]>(`${DomaineService._apiUrl}`).pipe(
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

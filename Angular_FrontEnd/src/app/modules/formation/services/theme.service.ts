import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { FORMATION_API_URL } from 'src/app/entities/Formation/formation';
import { Theme } from 'src/app/entities/Formation/theme';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {
  private _formations: Theme[] = [];
  constructor( private http: HttpClient) { }
  private static readonly _apiUrl = `${FORMATION_API_URL}/theme`;


  
  public getAllThemes(): Observable<Theme[]>{
    return this.http.get<Theme[]>(`${ThemeService._apiUrl}`).pipe(
      catchError(this.handleError)
    );
  }


  public getSthemeById(id:number) : Observable<Theme>{
    return this.http.get<Theme>(`${ThemeService._apiUrl}/${id}`).pipe(
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

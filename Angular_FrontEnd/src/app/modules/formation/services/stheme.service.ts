import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { FORMATION_API_URL } from 'src/app/entities/Formation/formation';
import { Stheme } from 'src/app/entities/Formation/sous-theme';

@Injectable({
  providedIn: 'root'
})

export class SthemeService {
  
  constructor( private http: HttpClient) { }
  private static readonly _apiUrl = `${FORMATION_API_URL}/stheme`;


  public getAllSthemes() : Observable<Stheme[]>{
    return this.http.get<Stheme[]>(`${SthemeService._apiUrl}`).pipe(
      catchError(this.handleError)
    );
  }



  public getSthemeByTheme(id:number) : Observable<Stheme[]>{
    return this.http.get<Stheme[]>(`${SthemeService._apiUrl}/theme/${id}`).pipe(
      catchError(this.handleError)
    );
  }



  public getThemeById(id:number) : Observable<Stheme>{
    return this.http.get<Stheme>(`${SthemeService._apiUrl}/${id}`).pipe(
      catchError(this.handleError)
    );
  }



  public getSthemeByCode(code : string) : Observable<Stheme>{
    return this.http.get<Stheme>(`${SthemeService._apiUrl}/search?code=${code}`).pipe(
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

import { Injectable } from '@angular/core';
import { Formation, FORMATION_API_URL } from 'src/app/entities/Formation/formation';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class FormationService {
  private _formations: Formation[] = [];
  constructor( private http: HttpClient) { }
  private static readonly _apiUrl = `${FORMATION_API_URL}/formation`;



  public getAllFormations(): Observable<Formation[]>{
    return this.http.get<Formation[]>(`${FormationService._apiUrl}`);
  }



  public getFormByStheme(id:number) : Observable<Formation[]>{
    return this.http.get<Formation[]>(`${FormationService._apiUrl}/stheme/${id}`);
  }

  public getFormByTheme(id:number) : Observable<Formation[]>{
    return this.http.get<Formation[]>(`${FormationService._apiUrl}/theme/${id}`);
  }



  public getFormById(id:number) : Observable<Formation>{
    return this.http.get<Formation>(`${FormationService._apiUrl}/${id}`);
  }



  public addFormation(f: Formation) : Observable<Formation>{
    console.log("execute add")
    return this.http.post<Formation>(`${FormationService._apiUrl}`,f).pipe(
      catchError(this.handleError)
    );
  }



  public editFormation(id:number, f:Formation) : Observable<Formation>{
    return this.http.put<Formation>(`${FormationService._apiUrl}/${id}`,f).pipe(
      catchError(this.handleError)
    );
  }



  public searchFormByWord(word : string) : Observable<Formation[]>{
    return this.http.get<Formation[]>(`${FormationService._apiUrl}/search?word=${word}`).pipe(
      catchError(this.handleError)
    );
  }



  public deleteForm(id:number): Observable<boolean>{
    return this.http.delete<boolean>(`${FormationService._apiUrl}/${id}`).pipe(
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

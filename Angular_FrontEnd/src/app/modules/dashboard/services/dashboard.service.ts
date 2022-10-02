import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError, of } from 'rxjs';
import { Formation } from 'src/app/entities/Formation/formation';
import { Session } from '../../session/entities/Session';


@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  public formations : Formation[];

  public sessions : Session[];
  
  private readonly FORMATION_API_URL = 'http://it-training-bdd.cloudapps-cm.com:8081/FormationRestApi/rest/formation';

  private readonly SESSION_API_URL = 'http://it-training-bdd.cloudapps-cm.com:8081/FormationRestApi/rest/session';

  private readonly FORMATION_SESSION_API_URL = 'http://it-training-bdd.cloudapps-cm.com:8081/FormationRestApi/rest/session/formation';

  constructor(private http: HttpClient) { }

  public getApiFormations(): Observable<Formation[]>{
    return this.http.get<Formation[]>(this.FORMATION_API_URL).pipe(
      catchError(this.handleError)
    );
  }

  public getFormationSessions(id: number): Observable<Session[]>{
    const url = `${this.FORMATION_SESSION_API_URL}/${id}`;
     return this.http.get<Session[]>(url).pipe(
       catchError(this.handleError)
     );
   }

   public getSessionById(id: number): Observable<Session> {
    const url = `${this.SESSION_API_URL}/${id}`;
    return this.http.get<Session>(url).pipe(
      catchError(this.handleError)
    );
  }

  public getFormationById(id: number): Observable<Formation> {

    const url = `${this.FORMATION_API_URL}/${id}`;
    return this.http.get<Formation>(url).pipe(
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
    return throwError(
      'Something bad happened; please try again later.');
  }

}


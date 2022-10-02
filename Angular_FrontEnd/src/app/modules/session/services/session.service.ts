import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { FORMATION_API_URL } from 'src/app/entities/Formation/formation';
import { Session } from '../entities/Session';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(private http: HttpClient) { }

  private static readonly _apiUrl = `${FORMATION_API_URL}/session`;

  public getAllSessions() : Observable<Session[]>{
    return this.http.get<Session[]>(`${SessionService._apiUrl}`).pipe(
      catchError(this.handleError)
    );
  }



  public getSessionByFormation(id:number) : Observable<Session[]>{
    return this.http.get<Session[]>(`${SessionService._apiUrl}/formation/${id}`).pipe(
      catchError(this.handleError)
    );
  }


  public addSession(s: Session) : Observable<Session>{
    console.log("execute add")
    return this.http.post<Session>(`${SessionService._apiUrl}`,s).pipe(
      catchError(this.handleError)
    );
  }



  public editSession(id:number, s:Session) : Observable<Session>{
    return this.http.put<Session>(`${SessionService._apiUrl}/${id}`,s).pipe(
      catchError(this.handleError)
    );
  }


  public deleteSession(id:number): Observable<boolean>{
    return this.http.delete<boolean>(`${SessionService._apiUrl}/${id}`).pipe(
      catchError(this.handleError)
    );
  }


  public getSessionById(id:number) : Observable<Session>{
    return this.http.get<Session>(`${SessionService._apiUrl}/${id}`).pipe(
      catchError(this.handleError)
    );
  }



  public getSessionByCode(code : string) : Observable<Session>{
    return this.http.get<Session>(`${SessionService._apiUrl}/search?code=${code}`).pipe(
      catchError(this.handleError)
    );
  }


  public CodeSessionExist(code : string) : Observable<Boolean>{
    return this.http.get<Boolean>(`${SessionService._apiUrl}/exist?code=${code}`).pipe(
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

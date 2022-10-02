import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { FORMATION_API_URL } from 'src/app/entities/Formation/formation';
import { Inscription } from 'src/app/entities/Inscription/Inscription';

@Injectable({
  providedIn: 'root'
})
export class InscriptionService {
  constructor(private http: HttpClient) { }

  private static readonly _apiUrl = `${FORMATION_API_URL}/inscription`;

  public getAllInscriptions() : Observable<Inscription[]>{
    return this.http.get<Inscription[]>(`${InscriptionService._apiUrl}`).pipe(
      catchError(this.handleError)
    );
  }


  public getAllByApprenant(id:number) : Observable<Inscription[]>{
    return this.http.get<Inscription[]>(`${InscriptionService._apiUrl}/apprenant/${id}`).pipe(
      catchError(this.handleError)
    );
  }


  public addInscription(i: Inscription) : Observable<Inscription>{
    console.log("execute add")
    return this.http.post<Inscription>(`${InscriptionService._apiUrl}`,i).pipe(
      catchError(this.handleError)
    );
  }



  public editInscription(id:number, i:Inscription) : Observable<Inscription>{
    return this.http.put<Inscription>(`${InscriptionService._apiUrl}/${id}`,i).pipe(
      catchError(this.handleError)
    );
  }


  public deleteInscription(id:number): Observable<boolean>{
    return this.http.delete<boolean>(`${InscriptionService._apiUrl}/${id}`).pipe(
      catchError(this.handleError)
    );
  }


  public getInscriptionById(id:number) : Observable<Inscription>{
    return this.http.get<Inscription>(`${InscriptionService._apiUrl}/${id}`).pipe(
      catchError(this.handleError)
    );
  }



  public getInscriptionByCode(code : string) : Observable<Inscription>{
    return this.http.get<Inscription>(`${InscriptionService._apiUrl}/search?code=${code}`).pipe(
      catchError(this.handleError)
    );
  }


  public CodeInscriptionExist(code : string) : Observable<Boolean>{
    return this.http.get<Boolean>(`${InscriptionService._apiUrl}/exist?code=${code}`).pipe(
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

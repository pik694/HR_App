import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {User} from './user';
import {Observable} from 'rxjs/Observable';
import {ErrorObservable} from 'rxjs/observable/ErrorObservable';
import {catchError} from 'rxjs/operators';

@Injectable()
export class UsersService {

    constructor(private http: HttpClient
    ) {
    }

    readonly API_URL: string = 'api/users';

    private static formatErrors(error: any) {
        return new ErrorObservable(error.error);
    }

    getUsers(): Observable<User[]> {
        const params = new HttpParams();
        return this.http.get(`${this.API_URL}`, {params})
            .pipe(catchError(UsersService.formatErrors));
    }

    getUser(id: Number): Observable<User> {
        const params = new HttpParams();
        return this.http.get(`${this.API_URL}/${id}`, {params})
            .pipe(catchError(UsersService.formatErrors));
    }

    createRecruiter(recruiter: User): Observable<any> {
        console.log('Creating a user!');
        return this.http.post(`${this.API_URL}`, recruiter)
            .pipe(catchError(UsersService.formatErrors));
    }

    deleteUser(recruiter: User): Observable<any> {
        return this.http.delete(`${this.API_URL}/${recruiter.id}`)
            .pipe(catchError(UsersService.formatErrors));
    }

    updateUser(recruiter: User): Observable<any> {
        return this.http.put(`${this.API_URL}/${recruiter.id}`, recruiter)
            .pipe(catchError(UsersService.formatErrors));
    }
}

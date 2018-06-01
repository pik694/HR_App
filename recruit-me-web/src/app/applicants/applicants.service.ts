import {Injectable} from '@angular/core';
import {ErrorObservable} from "rxjs/observable/ErrorObservable";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Applicant} from "./applicant";
import {catchError} from "rxjs/operators";

@Injectable()
export class ApplicantsService {

    constructor(private http: HttpClient
    ) {
    }

    readonly API_URL: string = 'api/applicants';

    private static formatErrors(error: any) {
        return new ErrorObservable(error.error);
    }

    getApplicants(): Observable<Applicant[]> {
        const params = new HttpParams();
        return this.http.get(`${this.API_URL}`, {params})
            .pipe(catchError(ApplicantsService.formatErrors));
    }

    getApplicant(id: number): Observable<Applicant> {
        const params = new HttpParams();
        return this.http.get(`${this.API_URL}/${id}`, {params})
            .pipe(catchError(ApplicantsService.formatErrors));
    }

    createApplicant(appl: Applicant): Observable<any> {
        return this.http.post(`${this.API_URL}`, appl)
            .pipe(catchError(ApplicantsService.formatErrors));
    }

    deleteApplicant(appl: Applicant): Observable<any> {
        return this.http.delete(`${this.API_URL}/${appl.id}`)
            .pipe(catchError(ApplicantsService.formatErrors));
    }

    updateApplicant(appl: Applicant): Observable<any> {
        return this.http.put(`${this.API_URL}/${appl.id}`, appl)
            .pipe(catchError(ApplicantsService.formatErrors));
    }
}

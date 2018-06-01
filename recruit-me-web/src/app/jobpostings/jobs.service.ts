import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {ErrorObservable} from "rxjs/observable/ErrorObservable";
import {Observable} from "rxjs/Observable";
import {JobPosting} from "./jobposting";
import {catchError} from "rxjs/operators";

@Injectable()
export class JobsService {

    constructor(private http: HttpClient
    ) {
    }

    readonly API_URL: string = 'api/jobs';

    private static formatErrors(error: any) {
        return new ErrorObservable(error.error);
    }

    getJobPostings(): Observable<JobPosting[]> {
        const params = new HttpParams();
        return this.http.get(`${this.API_URL}`, {params})
            .pipe(catchError(JobsService.formatErrors));
    }

    getJobPosting(id: number): Observable<JobPosting> {
        const params = new HttpParams();
        return this.http.get(`${this.API_URL}/${id}`, {params})
            .pipe(catchError(JobsService.formatErrors));
    }

    createJobPosting(job: JobPosting): Observable<any> {
        return this.http.post(`${this.API_URL}`, job)
            .pipe(catchError(JobsService.formatErrors));
    }

    deleteJobPosting(job: JobPosting): Observable<any> {
        return this.http.delete(`${this.API_URL}/${job.id}`)
            .pipe(catchError(JobsService.formatErrors));
    }

    updateJobPosting(job: JobPosting): Observable<any> {
        return this.http.put(`${this.API_URL}/${job.id}`, job)
            .pipe(catchError(JobsService.formatErrors));
    }

}

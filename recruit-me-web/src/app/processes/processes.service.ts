import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {ErrorObservable} from 'rxjs/observable/ErrorObservable';
import {Observable} from 'rxjs/Observable';
import {Process} from './process';
import {catchError} from 'rxjs/operators';

@Injectable()
export class ProcessesService {

    constructor(private http: HttpClient
    ) {
    }

    readonly API_URL: string = 'api/processes';

    private static formatErrors(error: any) {
        return new ErrorObservable(error.error);
    }

    getProcesses(): Observable<Process[]> {
        const params = new HttpParams();
        return this.http.get(`${this.API_URL}`, {params})
            .pipe(catchError(ProcessesService.formatErrors));
    }

    getProcessesForJob(jobId: number): Observable<Process[]> {
        const params = new HttpParams();
        return this.http.get(`/api/jobs/${jobId}/processes`, {params})
            .pipe(catchError(ProcessesService.formatErrors));
    }

    getProcessesForApplicant(applicantId: number): Observable<Process[]> {
        const params = new HttpParams();
        return this.http.get(`/api/applicants/${applicantId}/processes`, {params})
            .pipe(catchError(ProcessesService.formatErrors));
    }

    getProcess(id: number): Observable<Process> {
        const params = new HttpParams();
        return this.http.get(`${this.API_URL}/${id}`, {params})
            .pipe(catchError(ProcessesService.formatErrors));
    }

    createProcess(proc: Process): Observable<any> {
        return this.http.post(`${this.API_URL}`, proc)
            .pipe(catchError(ProcessesService.formatErrors));
    }

    deleteProcess(proc: Process): Observable<any> {
        return this.http.delete(`${this.API_URL}/${proc.id}`)
            .pipe(catchError(ProcessesService.formatErrors));
    }

    updateProcess(proc: Process): Observable<any> {
        return this.http.put(`${this.API_URL}/${proc.id}`, proc)
            .pipe(catchError(ProcessesService.formatErrors));
    }
}

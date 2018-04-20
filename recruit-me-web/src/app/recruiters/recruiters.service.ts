import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Recruiter} from "./recruiter";
import {Observable} from "rxjs/Observable";
import {ErrorObservable} from "rxjs/observable/ErrorObservable";
import {catchError} from "rxjs/operators";

@Injectable()
export class RecruitersService {

  constructor(private http: HttpClient
  ) { }

  readonly API_URL: string = "api/recruiters";

  getRecruiters() : Observable<Recruiter[]> {
    var params = new HttpParams();
    return this.http.get(`${this.API_URL}`, { params })
        .pipe(catchError(this.formatErrors));
  }

  getRecruiter(id: Number) : Observable<Recruiter> {
      var params = new HttpParams();
      return this.http.get(`${this.API_URL}/${id}`, { params })
          .pipe(catchError(this.formatErrors));
  }

  createRecruiter(recruiter: Recruiter) : Observable<any> {
      console.log("Creating a recruiter!");
      return this.http.post(`${this.API_URL}`, recruiter)
        .pipe(catchError(this.formatErrors));
  }

  deleteRecruiter(recruiter: Recruiter) : Observable<any> {
      return this.http.delete(`${this.API_URL}/${recruiter.id}`)
          .pipe(catchError(this.formatErrors));
  }

  updateRecruiter(recruiter: Recruiter) : Observable<any> {
      return this.http.put(`${this.API_URL}/${recruiter.id}`, recruiter)
          .pipe(catchError(this.formatErrors));
  }

  private formatErrors(error: any) {
      return new ErrorObservable(error.error);
  }
}

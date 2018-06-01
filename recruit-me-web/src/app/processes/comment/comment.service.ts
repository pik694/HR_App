import { Injectable } from '@angular/core';
import {ErrorObservable} from "rxjs/observable/ErrorObservable";
import {HttpClient} from "@angular/common/http";
import {catchError} from "rxjs/operators";
import {Comment} from "./comment";

@Injectable()
export class CommentService {

    constructor(private http: HttpClient
    ) {
    }

    readonly API_URL: string = 'api/comments';

    private static formatErrors(error: any) {
        return new ErrorObservable(error.error);
    }

    createCommentForProcess(com: Comment, procId: number) {
        return this.http.post(`api/processes/${procId}/comments`, com)
            .pipe(catchError(CommentService.formatErrors));
    }

    updateComment(com: Comment) {
        return this.http.put(`${this.API_URL}/${com.id}`, com)
            .pipe(catchError(CommentService.formatErrors));
    }

    deleteComment(com: Comment) {
        return this.http.delete(`${this.API_URL}/${com.id}`)
            .pipe(catchError(CommentService.formatErrors));
    }

}

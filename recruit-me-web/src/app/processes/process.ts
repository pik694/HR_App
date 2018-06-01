import {JobPosting} from "../jobpostings/jobposting";
import {Applicant} from "../applicants/applicant";
import {Comment} from "./comment/comment"

export enum ProcessStatus {
    New = "New",
    InvitedForTest = "Invited for test",
    DisqualifiedResume = "Resume not satisfying",
    InvitedForInterview = "Invited for interview",
    DisqualifiedInterview = "Interview not satisfying",
    Offered = "Offered",
    Hired = "Hired",
    Resigned = "Resigned"
}

export class Process {
    constructor(id: number = null, job: JobPosting = null, applicant: Applicant = null, status: number = null,
                comments: Comment[] = null, points: number = null) {
        this.id = id;
        this.job = job;
        this.applicant = applicant;
        this.status = status;
        this.points = points;
        this.comments = comments;
    }
    id: number;
    points: number;
    job: JobPosting;
    applicant: Applicant;
    status: number;
    comments: Comment[];

    static statuses: string[] = [
        "New",
        "Invited for test",
        "Resume not satisfying",
        "Invited for interview",
        "Interview not satisfying",
        "Offered",
        "Hired",
        "Resigned"
    ]
}
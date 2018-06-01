import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Router} from '@angular/router';
import {JobPosting} from '../jobposting';
import {JobsService} from '../jobs.service';

@Component({
  selector: 'app-jobpostings-list',
  templateUrl: './jobpostings-list.component.html',
  styleUrls: ['./jobpostings-list.component.css']
})
export class JobPostingsListComponent implements OnInit {
    @ViewChild('linkTemplate') linkTemplate: TemplateRef<any>;

    ngOnInit(): void {
        this.refreshList();

        this.columns = [
            {prop: 'id', name: 'Id', cellTemplate: this.linkTemplate},
            {prop: 'title', name: 'Title', cellTemplate: this.linkTemplate},
            {prop: 'salaryInfo', name: 'Salary', cellTemplate: this.linkTemplate},
        ];
    }

    constructor(private jobsService: JobsService, private router: Router) {
    }

    rows: Array<any>;
    columns: Array<any>;
    errorMsg: string;

    static jobPostingToRow(job: JobPosting) {
        return {
            id: job.id,
            title: job.title,
            salaryInfo: job.salaryInfo
        };
    }

    refreshList() {
        this.jobsService.getJobPostings().subscribe(
            jobs => {
                this.rows = [];
                jobs.forEach((job) => {
                    this.rows.push(JobPostingsListComponent.jobPostingToRow(job));
                });
                this.errorMsg = null;
            },
            error => {
                this.errorMsg = 'Could not connect to the server.';
            }
        );
    }

}

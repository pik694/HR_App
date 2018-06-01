import { Component, OnInit } from '@angular/core';
import {JobPosting} from "../jobposting";
import {ActivatedRoute, Router} from "@angular/router";
import {JobsService} from "../jobs.service";
import {isUndefined} from "util";

@Component({
  selector: 'app-jobpostings-form',
  templateUrl: './jobpostings-form.component.html',
  styleUrls: ['./jobpostings-form.component.css']
})
export class JobPostingsFormComponent implements OnInit {

    constructor(private jobsService: JobsService,
                private router: Router,
                private route: ActivatedRoute) {
    }

    model: JobPosting;
    editing: boolean;
    errorMsg: string;

    ngOnInit() {
        let id: number;
        this.route.params.subscribe(params => {
            id = params['id'];
            if (!isUndefined(id)) {
                this.editing = true;
                this.jobsService.getJobPosting(id).subscribe(job => this.model = job);
            } else {
                this.editing = false;
                this.model = new JobPosting();
            }
        });

    }

    saveJobPosting() {
        if (this.editing) {
            this.jobsService.updateJobPosting(this.model).subscribe(
                success => {
                    this.router.navigateByUrl('jobs/' + this.model.id);
                },
                error => {
                    this.errorMsg = 'Could not submit changes to the server';
                }
            );
        } else {
            this.jobsService.createJobPosting(this.model).subscribe(job => {
                    this.model = job;
                    this.router.navigateByUrl( 'jobs/' + this.model.id);
                },
                error => {
                    this.errorMsg = 'Could not submit changes to the server';
                }
            );
        }
    }

}

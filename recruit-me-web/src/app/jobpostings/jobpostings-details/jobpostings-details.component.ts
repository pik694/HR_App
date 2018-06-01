import {Component, Input, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {JobPosting} from '../jobposting';
import {JobsService} from '../jobs.service';
import {Process} from '../../processes/process';
import {ProcessesService} from '../../processes/processes.service';

@Component({
  selector: 'app-jobpostings-details',
  templateUrl: './jobpostings-details.component.html',
  styleUrls: ['./jobpostings-details.component.css']
})
export class JobPostingsDetailsComponent implements OnInit {
    @ViewChild('linkTemplate') linkTemplate: TemplateRef<any>;

    constructor(private route: ActivatedRoute,
                private router: Router,
                private service: JobsService,
                private procsService: ProcessesService) {
    }

    rows: Array<any>;
    columns: Array<any>;
    errorMsg: string;

    @Input() job: JobPosting = null;
    isDetailsPage = false;

    static processToRow(proc: Process) {
        return {
            id: proc.id,
            fName: proc.applicant.firstName,
            lName: proc.applicant.lastName,
            points: proc.points
        };
    }

    ngOnInit() {
        if (this.job == null) {
            this.isDetailsPage = true;
            this.columns = [
                {prop: 'id', name: 'Id', cellTemplate: this.linkTemplate},
                {prop: 'fName', name: 'Applicant\'s First Name', cellTemplate: this.linkTemplate},
                {prop: 'lName', name: 'Last Name', cellTemplate: this.linkTemplate},
                {prop: 'points', name: 'Points', cellTemplate: this.linkTemplate},
            ];
            this.route.params.forEach((params: Params) => {
                if (params['id'] !== undefined) {
                    const id = +params['id'];
                    this.service.getJobPosting(id).subscribe(job => {
                        this.job = job;
                        this.procsService.getProcessesForJob(job.id).subscribe( procs => {
                            this.rows = [];
                            procs.forEach( proc => {
                                    this.rows.push(JobPostingsDetailsComponent.processToRow(proc));
                                }
                            );
                        },
                        error => {
                            this.errorMsg = 'Could not connect to the server.';
                        });
                    });
                }
            });
        }
    }

    deleteJobPosting() {
        this.service.deleteJobPosting(this.job).subscribe(nothing => {
            this.router.navigateByUrl('/jobs');
        });
    }

}

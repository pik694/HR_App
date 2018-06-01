import {Component, Input, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {ApplicantsService} from "../applicants.service";
import {Applicant} from "../applicant";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {Process} from "../../processes/process";
import {ProcessesService} from "../../processes/processes.service";

@Component({
  selector: 'app-applicants-details',
  templateUrl: './applicants-details.component.html',
  styleUrls: ['./applicants-details.component.css']
})
export class ApplicantsDetailsComponent implements OnInit {
    @ViewChild('linkTemplate') linkTemplate: TemplateRef<any>;

    constructor(private route: ActivatedRoute,
                private router: Router,
                private service: ApplicantsService,
                private procsService: ProcessesService) {
    }

    @Input() applicant: Applicant = null;
    isApplicantsPage: boolean = false;

    rows: Array<any>;
    columns: Array<any>;
    errorMsg: string;

    static processToRow(proc: Process) {
        return {
            id: proc.id,
            title: proc.job.title,
            points: proc.points
        };
    }

    ngOnInit() {
        if (this.applicant == null) {
            this.isApplicantsPage = true;
            this.columns = [
                {prop: 'id', name: 'Id', cellTemplate: this.linkTemplate},
                {prop: 'title', name: 'Job Title', cellTemplate: this.linkTemplate},
                {prop: 'points', name: 'Score', cellTemplate: this.linkTemplate},
            ];
            this.route.params.forEach((params: Params) => {
                if (params['id'] !== undefined) {
                    const id = +params['id'];
                    this.service.getApplicant(id).subscribe(applicant => {
                        this.applicant = applicant;
                        this.procsService.getProcessesForApplicant(applicant.id).subscribe( procs => {
                            this.rows = [];
                            console.log(procs);
                            procs.forEach( proc => {
                                    this.rows.push(ApplicantsDetailsComponent.processToRow(proc))
                                },
                                error => {
                                    this.errorMsg = 'Could not connect to the server.';
                                }
                            )
                        })
                    });
                }
            });
        }
    }

    deleteApplicant() {
        this.service.deleteApplicant(this.applicant).subscribe(nothing => {
            this.router.navigateByUrl('/applicants');
        });
    }

}

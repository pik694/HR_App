import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {ApplicantsService} from "../applicants.service";
import {Router} from "@angular/router";
import {Applicant} from "../applicant";
import {DatePipe} from "@angular/common";

@Component({
    selector: 'app-applicants-list',
    templateUrl: './applicants-list.component.html',
    styleUrls: ['./applicants-list.component.css']
})
export class ApplicantsListComponent implements OnInit {
    @ViewChild('linkTemplate') linkTemplate: TemplateRef<any>;

    ngOnInit(): void {
        this.refreshList();

        this.columns = [
            {prop: 'id', name: 'Id', cellTemplate: this.linkTemplate},
            {prop: 'firstName', name: 'First Name', cellTemplate: this.linkTemplate},
            {prop: 'lastName', name: 'Last Name', cellTemplate: this.linkTemplate},
            {prop: 'birthDate', name: 'Date of birth', cellTemplate: this.linkTemplate},
            {prop: 'email', name: 'E-Mail', cellTemplate: this.linkTemplate},
            {prop: 'phoneNumber', name: 'Phone', cellTemplate: this.linkTemplate}
        ];
    }

    constructor(private service: ApplicantsService, private router: Router) {
    }

    static pipe: DatePipe = new DatePipe('en-US');
    rows: Array<any>;
    columns: Array<any>;
    errorMsg: string;

    static applicantToRow(appl: Applicant) {
        console.log(appl);
        return {
            id: appl.id,
            firstName: appl.firstName,
            lastName: appl.lastName,
            birthDate: ApplicantsListComponent.pipe.transform(appl.birthDate, 'd/M/yyyy'),
            email: appl.email,
            phoneNumber: appl.phoneNumber
        };
    }

    refreshList() {
        this.service.getApplicants().subscribe(
            applicants => {
                this.rows = [];
                applicants.forEach((appl) => {
                    this.rows.push(ApplicantsListComponent.applicantToRow(appl));
                });
                this.errorMsg = null;
            },
            error => {
                this.errorMsg = 'Could not connect to the server.';
            }
        );
    }

}

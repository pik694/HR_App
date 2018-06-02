import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ApplicantsService} from '../applicants.service';
import {Applicant, Resume} from '../applicant';
import {isUndefined} from 'util';

@Component({
  selector: 'app-applicants-form',
  templateUrl: './applicants-form.component.html',
  styleUrls: ['./applicants-form.component.css']
})
export class ApplicantsFormComponent implements OnInit {
    constructor(private service: ApplicantsService,
                private router: Router,
                private route: ActivatedRoute) {
    }

    model: Applicant;
    editing: boolean;
    errorMsg: string;

    ngOnInit() {
        let id: number;
        this.route.params.subscribe(params => {
            id = params['id'];
            if (!isUndefined(id)) {
                this.editing = true;
                this.service.getApplicant(id).subscribe(appl => this.model = appl);
            } else {
                this.editing = false;
                this.model = new Applicant();
            }
        });

    }

    saveApplicant() {
        if (this.editing) {
            this.service.updateApplicant(this.model).subscribe(
                success => {
                    this.router.navigateByUrl('applicants/' + this.model.id);
                },
                error => {
                    this.errorMsg = 'Could not submit changes to the server';
                }
            );
        } else {
            this.service.createApplicant(this.model).subscribe(appl => {
                    this.model = appl;
                    this.router.navigateByUrl('applicants/' + this.model.id);
                },
                error => {
                    this.errorMsg = 'Could not submit changes to the server';
                }
            );
        }
    }

    onFileChange(event) {
        const reader = new FileReader();
        if (event.target.files && event.target.files.length > 0) {
            const file = event.target.files[0];
            reader.readAsDataURL(file);
            reader.onload = () => {
                this.model.resume = new Resume(file.name, reader.result.split(',')[1]);
            };
        }
    }

}

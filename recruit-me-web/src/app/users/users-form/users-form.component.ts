import {Component, OnInit} from '@angular/core';
import {User} from '../user';
import {UsersService} from '../users.service';
import {Router, ActivatedRoute} from '@angular/router';
import {isUndefined} from 'util';

@Component({
    selector: 'app-users-form',
    templateUrl: './users-form.component.html',
    styleUrls: ['./users-form.component.css']
})
export class UsersFormComponent implements OnInit {

    constructor(private recruiterService: UsersService,
                private router: Router,
                private route: ActivatedRoute) {
    }

    model: User;
    editing: boolean;
    errorMsg: string;

    ngOnInit() {
        let id: number;
        this.route.params.subscribe(params => {
            id = params['id'];
            if (!isUndefined(id)) {
                this.editing = true;
                this.recruiterService.getUser(id).subscribe(recruiter => this.model = recruiter);
            } else {
                this.editing = false;
                this.model = new User();
            }
        });

    }

    saveRecruiter() {
        if (this.editing) {
            this.recruiterService.updateUser(this.model).subscribe(
                success => {
                    this.router.navigateByUrl('users/' + this.model.id);
                },
                error => {
                    this.errorMsg = 'Could not submit changes to the server';
                }
            );
        } else {
            this.recruiterService.createRecruiter(this.model).subscribe(recruiter => {
                    this.model = recruiter;
                    this.router.navigateByUrl('users/' + this.model.id);
                },
                error => {
                    this.errorMsg = 'Could not submit changes to the server';
                }
            );
        }
    }

}

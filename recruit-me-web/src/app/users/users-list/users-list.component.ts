import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {User} from '../user';
import {UsersService} from '../users.service';
import {Router} from '@angular/router';
import {routes} from '../../routes';

@Component({
    selector: 'app-users-list',
    templateUrl: './users-list.component.html',
    styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {
    @ViewChild('linkTemplate') linkTemplate: TemplateRef<any>;

    constructor(private usersService: UsersService, private router: Router) {
    }

    rows: Array<any>;
    columns: Array<any>;
    errorMsg: string;

    static recruiterToRow(recruiter: User) {
        return {
            id: recruiter.id,
            username: recruiter.username,
            email: recruiter.email,
            firstName: recruiter.firstName,
            lastName: recruiter.lastName,
        };
    }

    ngOnInit() {
        this.refreshList();

        this.columns = [
            {prop: 'id', name: 'Id', cellTemplate: this.linkTemplate},
            {prop: 'username', name: 'Username', cellTemplate: this.linkTemplate},
            {prop: 'email', name: 'E-mail', cellTemplate: this.linkTemplate},
            {prop: 'firstName', name: 'First Name', cellTemplate: this.linkTemplate},
            {prop: 'lastName', name: 'Last Name', cellTemplate: this.linkTemplate},
        ];

    }

    refreshList() {
        this.usersService.getUsers().subscribe(
            users => {
                this.rows = [];
                users.forEach((recruiter) => {
                    this.rows.push(UsersListComponent.recruiterToRow(recruiter));
                });
                this.errorMsg = null;
            },
            error => {
                this.errorMsg = 'Could not connect to the server.';
            }
        );
    }

    viewDetails(event) {
        console.log(event);
        this.router.navigateByUrl(routes.RECRUITERS_BASE_ROUTE + '/' + event.row.id);
    }
}

import {Component, OnInit} from '@angular/core';
import {User} from '../user';
import {UsersService} from '../users.service';
import {Router} from '@angular/router';

@Component({
    selector: 'app-users-list',
    templateUrl: './users-list.component.html',
    styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {

    constructor(private usersService: UsersService) {
    }

    rows: Array<any>;
    columns: Array<any>;
    errorMsg: string;

    static recruiterToRow(recruiter: User) {
        return {
            id: '<a href="/users/' + recruiter.id + '">' + recruiter.id + '</a>',
            username: '<a href="/users/' + recruiter.id + '">' + recruiter.username + '</a>',
            email: '<a href="/users/' + recruiter.id + '">' + recruiter.email + '</a>',
            firstName: '<a href="/users/' + recruiter.id + '">' + recruiter.firstName + '</a>',
            lastName: '<a href="/users/' + recruiter.id + '">' + recruiter.lastName + '</a>'
        };
    }

    ngOnInit() {
        this.refreshList();

        this.columns = [
            {prop: 'id', name: 'Id'},
            {prop: 'username', name: 'Username'},
            {prop: 'email', name: 'E-mail'},
            {prop: 'firstName', name: 'First Name'},
            {prop: 'lastName', name: 'Last Name'},
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

}

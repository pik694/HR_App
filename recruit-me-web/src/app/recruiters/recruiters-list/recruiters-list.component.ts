import { Component, OnInit } from '@angular/core';
import {Recruiter} from '../recruiter';
import {RecruitersService} from '../recruiters.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-recruiters-list',
  templateUrl: './recruiters-list.component.html',
  styleUrls: ['./recruiters-list.component.css']
})
export class RecruitersListComponent implements OnInit {

  constructor(private recruitersService: RecruitersService) { }

  rows: Array<any>;
  columns: Array<any>;

    ngOnInit() {
        this.refreshList();
        //this.router.events.subscribe( e => this.refreshList() );

        this.columns = [
            { prop: 'id', name: 'Id' },
            { prop: 'username', name: 'Username'},
            { prop: 'email', name: 'E-mail'},
            { prop: 'firstName', name: 'First Name'},
            { prop: 'lastName', name: 'Last Name' },
        ];

    }

    static recruiterToRow(recruiter: Recruiter) {
        return {
            id: '<a href="/recruiters/' + recruiter.id + '">' + recruiter.id + '</a>',
            username: '<a href="/recruiters/' + recruiter.id + '">' + recruiter.username + '</a>',
            email: '<a href="/recruiters/' + recruiter.id + '">' + recruiter.email + '</a>',
            firstName: '<a href="/recruiters/' + recruiter.id + '">' + recruiter.firstName + '</a>',
            lastName: '<a href="/recruiters/' + recruiter.id + '">' + recruiter.lastName + '</a>'
        };
    }

    refreshList() {
        this.recruitersService.getRecruiters().subscribe(
            recruiters => {
                this.rows = [];
                recruiters.forEach( (recruiter) => {
                    this.rows.push(RecruitersListComponent.recruiterToRow(recruiter));
                });
            }
        );
    }

}

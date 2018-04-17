import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-applicants-list',
  templateUrl: './applicants-list.component.html',
  styleUrls: ['./applicants-list.component.css']
})
export class ApplicantsListComponent implements OnInit {

  constructor() { }

  rows : Array<any>;
  columns : Array<any>;

  ngOnInit() {
    this.columns = [
        { prop: 'id', name: 'Id' },
        { prop: 'fName', name: 'First Name'},
        { prop: 'lName', name: 'Last Name' },
        { prop: 'birthDate', name: 'Date of birth' },
        { prop: 'pesel', name: 'Pesel'}
    ];
    this.rows = [
        { id: '1', fName: 'Bob', lName: 'Johnson', birthDate: new Date()/*'1.1.1990'*/, pesel: '90010172543' },
        { id: '2', fName: 'Ann', lName: 'Bobson', birthDate: new Date()/*'1.1.1990'*/, pesel: '23452387534' }
    ];
  }

}

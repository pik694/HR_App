import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {UsersListComponent} from './users-list.component';
import {NgxDatatableModule} from '@swimlane/ngx-datatable';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {UsersService} from '../users.service';

describe('UsersListComponent', () => {
    let component: UsersListComponent;
    let fixture: ComponentFixture<UsersListComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            providers: [UsersService, HttpClient],
            declarations: [UsersListComponent],
            imports: [NgxDatatableModule, HttpClientModule]
        })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(UsersListComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
});

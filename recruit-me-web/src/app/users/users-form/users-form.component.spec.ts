import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {UsersFormComponent} from './users-form.component';
import {FormsModule} from '@angular/forms';
import {UsersService} from '../users.service';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {RouterTestingModule} from '@angular/router/testing';

describe('UsersFormComponent', () => {
    let component: UsersFormComponent;
    let fixture: ComponentFixture<UsersFormComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            providers: [UsersService, HttpClient],
            declarations: [UsersFormComponent],
            imports: [FormsModule, HttpClientModule, RouterTestingModule]
        })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(UsersFormComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});

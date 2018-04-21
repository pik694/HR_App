import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {RecruitersDetailsComponent} from './users-details.component';
import {RouterTestingModule} from '@angular/router/testing';
import {UsersService} from '../users.service';
import {HttpClient, HttpClientModule} from '@angular/common/http';

describe('UsersDetailsComponent', () => {
    let component: RecruitersDetailsComponent;
    let fixture: ComponentFixture<RecruitersDetailsComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            providers: [UsersService, HttpClient],
            imports: [RouterTestingModule, HttpClientModule],
            declarations: [RecruitersDetailsComponent]
        })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(RecruitersDetailsComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});

import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {RecruitersDetailsComponent} from './recruiters-details.component';
import {RouterTestingModule} from '@angular/router/testing';
import {RecruitersService} from '../recruiters.service';
import {HttpClient, HttpClientModule} from '@angular/common/http';

describe('RecruitersDetailsComponent', () => {
    let component: RecruitersDetailsComponent;
    let fixture: ComponentFixture<RecruitersDetailsComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            providers: [RecruitersService, HttpClient],
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

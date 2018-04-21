import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecruitersFormComponent } from './recruiters-form.component';
import {FormsModule} from '@angular/forms';
import {RecruitersService} from '../recruiters.service';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {RouterTestingModule} from '@angular/router/testing';

describe('RecruitersFormComponent', () => {
  let component: RecruitersFormComponent;
  let fixture: ComponentFixture<RecruitersFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      providers: [RecruitersService, HttpClient],
      declarations: [ RecruitersFormComponent ],
      imports: [ FormsModule, HttpClientModule, RouterTestingModule ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecruitersFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

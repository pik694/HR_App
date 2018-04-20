import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecruitersListComponent } from './recruiters-list.component';
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {RecruitersService} from "../recruiters.service";

describe('RecruitersListComponent', () => {
  let component: RecruitersListComponent;
  let fixture: ComponentFixture<RecruitersListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      providers: [RecruitersService, HttpClient],
      declarations: [ RecruitersListComponent ],
      imports: [ NgxDatatableModule, HttpClientModule ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecruitersListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
});

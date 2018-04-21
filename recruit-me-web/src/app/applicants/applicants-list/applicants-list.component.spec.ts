import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplicantsListComponent } from './applicants-list.component';
import {NgxDatatableModule} from '@swimlane/ngx-datatable';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule} from '@angular/router';

describe('ApplicantsListComponent', () => {
  let component: ApplicantsListComponent;
  let fixture: ComponentFixture<ApplicantsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApplicantsListComponent ],
      imports: [ NgxDatatableModule, HttpClientModule, RouterModule ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApplicantsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecruitersDetailsComponent } from './recruiters-details.component';

describe('RecruitersDetailsComponent', () => {
  let component: RecruitersDetailsComponent;
  let fixture: ComponentFixture<RecruitersDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecruitersDetailsComponent ]
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

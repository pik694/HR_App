import {TestBed, inject, getTestBed} from '@angular/core/testing';

import { RecruitersService } from './recruiters.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import {HttpClientModule} from '@angular/common/http';
import {Recruiter} from './recruiter';

describe('RecruitersService', () => {

    let injector: TestBed;
    let service: RecruitersService;
    let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RecruitersService],
      imports: [
          HttpClientModule,
          HttpClientTestingModule
      ]
    });
      injector = getTestBed();
      service = injector.get(RecruitersService);
      httpMock = injector.get(HttpTestingController);
  });

  afterEach(() => {
      httpMock.verify();
  });

  it('should be created', inject([RecruitersService], (service: RecruitersService) => {
    expect(service).toBeTruthy();
  }));

  it('should get all recruiters', () => {
    const dummyRecruiters = [
        new Recruiter(1, 'bob'),
        new Recruiter(2, 'john'),
        new Recruiter(3, 'recr', 'recr@recruiters.com')
    ];

    service.getRecruiters().subscribe( recruiters => {
      expect(recruiters.length).toBe(3);
      expect(recruiters).toEqual(dummyRecruiters);
    });

    const req = httpMock.expectOne(`${service.API_URL}`);
    expect(req.request.method).toBe('GET');
    req.flush(dummyRecruiters);
  });

  it('should get single recruiter', () => {
    const john = new Recruiter(2, 'john');

    service.getRecruiter(john.id).subscribe( recruiter  => {
        expect(recruiter).toEqual(john);
    });

    const req = httpMock.expectOne(`${service.API_URL}/${john.id}`);
    expect(req.request.method).toBe('GET');
    req.flush(john);
  });

});

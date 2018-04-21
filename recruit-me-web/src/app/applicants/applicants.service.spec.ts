import { TestBed, inject } from '@angular/core/testing';

import { ApplicantsService } from './applicants.service';
import {NgxDatatableModule} from '@swimlane/ngx-datatable';

describe('ApplicantsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ApplicantsService],
      imports: [ NgxDatatableModule ]
    });
  });

  it('should be created', inject([ApplicantsService], (service: ApplicantsService) => {
    expect(service).toBeTruthy();
  }));
});

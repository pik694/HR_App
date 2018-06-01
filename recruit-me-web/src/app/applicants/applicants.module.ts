import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {SharedModule} from '../shared/shared.module';
import {ApplicantsRoutingModule} from './applicants-routing.module';
import { ApplicantsDetailsComponent } from './applicants-details/applicants-details.component';
import { ApplicantsFormComponent } from './applicants-form/applicants-form.component';
import {ApplicantsListComponent} from './applicants-list/applicants-list.component';
import {ApplicantsService} from './applicants.service';
import {ProcessesService} from '../processes/processes.service';

@NgModule({
  imports: [
      CommonModule,
      ApplicantsRoutingModule,
      SharedModule
  ],
    exports: [
        ApplicantsDetailsComponent
    ],
  declarations: [ApplicantsDetailsComponent, ApplicantsFormComponent, ApplicantsListComponent],
    providers: [ApplicantsService, ProcessesService]
})
export class ApplicantsModule { }

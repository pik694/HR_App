import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { JobPostingsListComponent } from './jobpostings-list/jobpostings-list.component';
import {SharedModule} from "../shared/shared.module";
import {JobsRoutingModule} from "./jobs-routing.module";
import {JobPostingsFormComponent} from './jobpostings-form/jobpostings-form.component';
import { JobPostingsDetailsComponent } from './jobpostings-details/jobpostings-details.component';
import {JobsService} from "./jobs.service";
import {ProcessesService} from "../processes/processes.service";

@NgModule({
  imports: [
    CommonModule,
      JobsRoutingModule,
      SharedModule
  ],
    exports: [
        JobPostingsDetailsComponent
    ],
  declarations: [JobPostingsListComponent, JobPostingsFormComponent, JobPostingsDetailsComponent],
    providers: [JobsService, ProcessesService]
})
export class JobPostingsModule {
}

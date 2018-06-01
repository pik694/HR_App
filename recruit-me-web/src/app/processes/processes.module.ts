import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProcessDetailsComponent } from './process-details/process-details.component';
import {JobPostingsModule} from '../jobpostings/jobpostings.module';
import {ApplicantsModule} from '../applicants/applicants.module';
import {SharedModule} from '../shared/shared.module';
import {ProcessesRoutingModule} from './processes-routing.module';
import { CommentComponent } from './comment/comment.component';
import {ProcessesService} from './processes.service';
import {CommentService} from './comment/comment.service';

@NgModule({
  imports: [
    CommonModule,
      SharedModule,
      ProcessesRoutingModule,
      JobPostingsModule,
      ApplicantsModule,
  ],
  declarations: [ProcessDetailsComponent, CommentComponent],
    providers: [ProcessesService, CommentService]
})
export class ProcessesModule { }

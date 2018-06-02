import { Component, OnInit } from '@angular/core';
import {Process} from '../../processes/process';
import {isUndefined} from 'util';
import {ProcessesService} from '../../processes/processes.service';
import {JobPosting} from '../../jobpostings/jobposting';
import {JobsService} from '../../jobpostings/jobs.service';
import {Applicant} from '../../applicants/applicant';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-process-form',
  templateUrl: './process-form.component.html',
  styleUrls: ['./process-form.component.css']
})
export class ProcessFormComponent implements OnInit {

  constructor(private procService: ProcessesService,
              private jobService: JobsService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
      this.route.params.subscribe(params => {
          this.jobId = params['jobid'];
          const id = params['id'];
          if (!isUndefined(this.jobId)) {
              this.editing = false;
              this.model = new Process();
              this.jobService.getJobPosting(this.jobId).subscribe(job => this.job = job);
          } else {
              this.editing = true;
              this.procService.getProcess(id).subscribe(proc => this.model = proc);
          }
          this.statuses = Process.statuses;
      });
  }
    statuses: string[];
    job: JobPosting;
    model: Process;
    editing: boolean;
    errorMsg: string;
    jobId: number;
    applicantId: number;

    saveProcess() {
      if (this.editing) {
        this.model.job.id = this.jobId;
        this.model.applicant.id = this.applicantId;
        this.procService.updateProcess(this.model).subscribe(proc => {
            this.router.navigateByUrl('/processes/' + this.model.id);
        });
      } else {
          this.model.applicant = new Applicant(this.applicantId);
          this.model.job = new JobPosting(this.jobId);
          this.procService.createProcess(this.model).subscribe(proc => {
              this.router.navigateByUrl('/processes/' + proc.id);
          });
      }
    }
}

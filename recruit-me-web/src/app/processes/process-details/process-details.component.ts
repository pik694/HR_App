import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {ProcessesService} from '../processes.service';
import {Process} from '../process';
import {Comment} from '../comment/comment';

@Component({
  selector: 'app-process-details',
  templateUrl: './process-details.component.html',
  styleUrls: ['./process-details.component.css']
})
export class ProcessDetailsComponent implements OnInit {

    constructor(private route: ActivatedRoute,
                private router: Router,
                private service: ProcessesService) {
    }

    process: Process;
    statuses: string[];

    ngOnInit() {
        this.statuses = Process.statuses;
        this.route.params.forEach((params: Params) => {
            if (params['id'] !== undefined) {
                const id = +params['id'];
                this.service.getProcess(id).subscribe(proc => {
                    this.process = proc;
                });
                console.log(id);
                console.log(this.process);
            }
        });
    }

    deleteProcess() {
        this.service.deleteProcess(this.process).subscribe(nothing => {
            this.router.navigateByUrl('/jobs');
        });
    }

    newComment(comment: Comment) {
        this.process.comments.push(comment);
    }

    commentDeleted(comment: Comment) {
        this.process.comments.splice(this.process.comments.indexOf(comment), 1);
    }
}

import { Component, OnInit } from '@angular/core';
import {Recruiter} from "../recruiter";
import {RecruitersService} from "../recruiters.service";
import { Router, ActivatedRoute } from "@angular/router";
import {routes} from "../../routes";
import {isUndefined} from "util";

@Component({
  selector: 'app-recruiters-form',
  templateUrl: './recruiters-form.component.html',
  styleUrls: ['./recruiters-form.component.css']
})
export class RecruitersFormComponent implements OnInit {

  constructor(
      private recruiterService : RecruitersService,
      private router: Router,
      private route: ActivatedRoute
  ) { }

  model: Recruiter;
  editing: boolean;

  ngOnInit() {
    let id: Number;
    this.route.params.subscribe(params => {
      id = params['id'];
      if (!isUndefined(id)) {
          this.editing = true;
          this.recruiterService.getRecruiter(id).subscribe( recruiter => this.model = recruiter );
      }
      else {
          this.editing = false;
          this.model = new Recruiter();
      }
    });

  }

  saveRecruiter() {
    if (this.editing) {
      this.recruiterService.updateRecruiter(this.model).subscribe( nothing => {
          this.router.navigateByUrl(routes.RECRUITERS_BASE_ROUTE + "/" + this.model.id);
      });
    }
    else {
      this.recruiterService.createRecruiter(this.model).subscribe( recruiter => {
          this.model = recruiter
          this.router.navigateByUrl(routes.RECRUITERS_BASE_ROUTE + "/" + this.model.id);
      });
    }
  }

}

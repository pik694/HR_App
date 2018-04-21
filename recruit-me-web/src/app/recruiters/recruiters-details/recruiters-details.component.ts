import { Component, OnInit } from '@angular/core';
import {Recruiter} from '../recruiter';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {RecruitersService} from '../recruiters.service';
import {routes} from '../../routes';

@Component({
  selector: 'app-recruiters-details',
  templateUrl: './recruiters-details.component.html',
  styleUrls: ['./recruiters-details.component.css']
})
export class RecruitersDetailsComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private router: Router,
              private service: RecruitersService) { }

  recruiter: Recruiter;

  ngOnInit() {
    this.route.params.forEach((params: Params) => {
      if (params['id'] !== undefined) {
          const id = +params['id'];
          this.service.getRecruiter(id).subscribe( recruiter => this.recruiter = recruiter );
      }
    });
  }

    deleteRecruiter() {
      this.service.deleteRecruiter(this.recruiter).subscribe( nothing => {
        this.router.navigateByUrl(routes.RECRUITERS_BASE_ROUTE);
      });
    }
}


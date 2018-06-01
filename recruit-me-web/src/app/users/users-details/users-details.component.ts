import {Component, OnInit} from '@angular/core';
import {User} from '../user';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {UsersService} from '../users.service';
import {routes} from '../../routes';

@Component({
    selector: 'app-users-details',
    templateUrl: './users-details.component.html',
    styleUrls: ['./users-details.component.css']
})
export class UsersDetailsComponent implements OnInit {

    constructor(private route: ActivatedRoute,
                private router: Router,
                private service: UsersService) {
    }

    user: User;

    ngOnInit() {
        this.route.params.forEach((params: Params) => {
            if (params['id'] !== undefined) {
                const id = +params['id'];
                this.service.getUser(id).subscribe(recruiter => this.user = recruiter);
            }
        });
    }

    deleteUser() {
        this.service.deleteUser(this.user).subscribe(nothing => {
            this.router.navigateByUrl(routes.RECRUITERS_BASE_ROUTE);
        });
    }
}


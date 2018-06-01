import {TestBed, inject, getTestBed} from '@angular/core/testing';

import {UsersService} from './users.service';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import {HttpClientModule} from '@angular/common/http';
import {User} from './user';

describe('UsersService', () => {

    let injector: TestBed;
    let service: UsersService;
    let httpMock: HttpTestingController;

    beforeEach(() => {
        TestBed.configureTestingModule({
            providers: [UsersService],
            imports: [
                HttpClientModule,
                HttpClientTestingModule
            ]
        });
        injector = getTestBed();
        service = injector.get(UsersService);
        httpMock = injector.get(HttpTestingController);
    });

    afterEach(() => {
        httpMock.verify();
    });

    it('should be created', inject([UsersService], (Rservice: UsersService) => {
        expect(Rservice).toBeTruthy();
    }));

    it('should get all users', () => {
        const dummyRecruiters = [
            new User(1, 'bob'),
            new User(2, 'john'),
            new User(3, 'recr', 'recr@users.com')
        ];

        service.getUsers().subscribe(users => {
            expect(users.length).toBe(3);
            expect(users).toEqual(dummyRecruiters);
        });

        const req = httpMock.expectOne(`${service.API_URL}`);
        expect(req.request.method).toBe('GET');
        req.flush(dummyRecruiters);
    });

    it('should get single user', () => {
        const john = new User(2, 'john');

        service.getUser(john.id).subscribe(recruiter => {
            expect(recruiter).toEqual(john);
        });

        const req = httpMock.expectOne(`${service.API_URL}/${john.id}`);
        expect(req.request.method).toBe('GET');
        req.flush(john);
    });

});

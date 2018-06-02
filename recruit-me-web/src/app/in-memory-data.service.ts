import {InMemoryDbService, ParsedRequestUrl, RequestInfoUtilities} from 'angular-in-memory-web-api';
import {User} from './users/user';
import {JobPosting} from './jobpostings/jobposting';
import {Applicant, Resume} from './applicants/applicant';
import {Process, ProcessStatus} from './processes/process';
import {Comment} from './processes/comment/comment';

export class InMemoryDataService implements InMemoryDbService {
    parseRequestUrl(url: string, utils: RequestInfoUtilities): ParsedRequestUrl {
        let newUrl = url.replace(/\/api\/jobs\/.*\/processes/, '/api/jobsprocesses');
        newUrl = newUrl.replace(/\/api\/applicants\/.*\/processes/, '/api/applicantsprocesses');
        newUrl = newUrl.replace(/\/api\/processes\/.*\/comments/, '/api/comments');
        console.log('newUrl:', newUrl);
        const parsed = utils.parseRequestUrl(newUrl);
        console.log(`parseRequestUrl override of '${url}':`, parsed);
        return parsed;
    }

    createDb() {
        const users = [
            new User(1, 'bobsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(2, 'anniex', 'bob@bobmail.bob', 'Ann', 'Johnson'),
            new User(3, 'abcd', 'bob@bobmail.bob', 'John', 'Disculpe'),
            new User(4, 'dfgdfg', 'bob@bobmail.bob', 'Jerzy', 'Decapito'),
            new User(5, 'ret', 'bob@bobmail.bob', 'Vivienne', 'Cooper'),
            new User(6, 'bgsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(7, 'bfbske', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(8, 'bobsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(9, 'anniex', 'bob@bobmail.bob', 'Ann', 'Johnson'),
            new User(10, 'abcd', 'bob@bobmail.bob', 'John', 'Disculpe'),
            new User(11, 'dfgdfg', 'bob@bobmail.bob', 'Jerzy', 'Decapito'),
            new User(12, 'ret', 'bob@bobmail.bob', 'Vivienne', 'Cooper'),
            new User(13, 'bgsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(14, 'bfbske', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(15, 'bobsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(16, 'anniex', 'bob@bobmail.bob', 'Ann', 'Johnson'),
            new User(17, 'abcd', 'bob@bobmail.bob', 'John', 'Disculpe'),
            new User(18, 'dfgdfg', 'bob@bobmail.bob', 'Jerzy', 'Decapito'),
            new User(19, 'ret', 'bob@bobmail.bob', 'Vivienne', 'Cooper'),
            new User(20, 'abcd', 'bob@bobmail.bob', 'John', 'Disculpe'),
            new User(21, 'dfgdfg', 'bob@bobmail.bob', 'Jerzy', 'Decapito'),
            new User(22, 'ret', 'bob@bobmail.bob', 'Vivienne', 'Cooper'),
            new User(23, 'bgsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(24, 'bfbske', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(25, 'bobsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(26, 'anniex', 'bob@bobmail.bob', 'Ann', 'Johnson'),
            new User(27, 'abcd', 'bob@bobmail.bob', 'John', 'Disculpe'),
            new User(28, 'dfgdfg', 'bob@bobmail.bob', 'Jerzy', 'Decapito'),
            new User(29, 'ret', 'bob@bobmail.bob', 'Vivienne', 'Cooper'),
            new User(20, 'abcd', 'bob@bobmail.bob', 'John', 'Disculpe'),
            new User(21, 'dfgdfg', 'bob@bobmail.bob', 'Jerzy', 'Decapito'),
            new User(22, 'ret', 'bob@bobmail.bob', 'Vivienne', 'Cooper'),
            new User(23, 'bgsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(24, 'bfbske', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(25, 'bobsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(26, 'anniex', 'bob@bobmail.bob', 'Ann', 'Johnson'),
            new User(27, 'abcd', 'bob@bobmail.bob', 'John', 'Disculpe'),
            new User(28, 'dfgdfg', 'bob@bobmail.bob', 'Jerzy', 'Decapito'),
            new User(29, 'ret', 'bob@bobmail.bob', 'Vivienne', 'Cooper'),
            new User(30, 'abcd', 'bob@bobmail.bob', 'John', 'Disculpe'),
            new User(31, 'dfgdfg', 'bob@bobmail.bob', 'Jerzy', 'Decapito'),
            new User(32, 'ret', 'bob@bobmail.bob', 'Vivienne', 'Cooper'),
            new User(33, 'bgsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(34, 'bfbske', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(35, 'bobsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(36, 'anniex', 'bob@bobmail.bob', 'Ann', 'Johnson'),
            new User(37, 'abcd', 'bob@bobmail.bob', 'John', 'Disculpe'),
            new User(38, 'dfgdfg', 'bob@bobmail.bob', 'Jerzy', 'Decapito'),
            new User(39, 'ret', 'bob@bobmail.bob', 'Vivienne', 'Cooper'),
            new User(40, 'abcd', 'bob@bobmail.bob', 'John', 'Disculpe'),
            new User(41, 'dfgdfg', 'bob@bobmail.bob', 'Jerzy', 'Decapito'),
            new User(42, 'ret', 'bob@bobmail.bob', 'Vivienne', 'Cooper'),
            new User(43, 'bgsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(44, 'bfbske', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(45, 'bobsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(46, 'anniex', 'bob@bobmail.bob', 'Ann', 'Johnson'),
            new User(47, 'abcd', 'bob@bobmail.bob', 'John', 'Disculpe'),
            new User(48, 'dfgdfg', 'bob@bobmail.bob', 'Jerzy', 'Decapito'),
            new User(49, 'ret', 'bob@bobmail.bob', 'Vivienne', 'Cooper'),
            new User(50, 'abcd', 'bob@bobmail.bob', 'John', 'Disculpe'),
            new User(51, 'dfgdfg', 'bob@bobmail.bob', 'Jerzy', 'Decapito'),
            new User(52, 'ret', 'bob@bobmail.bob', 'Vivienne', 'Cooper'),
            new User(53, 'bgsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(54, 'bfbske', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(55, 'bobsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(56, 'anniex', 'bob@bobmail.bob', 'Ann', 'Johnson'),
            new User(57, 'abcd', 'bob@bobmail.bob', 'John', 'Disculpe'),
            new User(58, 'dfgdfg', 'bob@bobmail.bob', 'Jerzy', 'Decapito'),
            new User(59, 'ret', 'bob@bobmail.bob', 'Vivienne', 'Cooper'),
            new User(60, 'abcd', 'bob@bobmail.bob', 'John', 'Disculpe'),
            new User(61, 'dfgdfg', 'bob@bobmail.bob', 'Jerzy', 'Decapito'),
            new User(62, 'ret', 'bob@bobmail.bob', 'Vivienne', 'Cooper'),
            new User(63, 'bgsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(64, 'bfbske', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(65, 'bobsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new User(66, 'anniex', 'bob@bobmail.bob', 'Ann', 'Johnson'),
            new User(67, 'abcd', 'bob@bobmail.bob', 'John', 'Disculpe'),
            new User(68, 'dfgdfg', 'bob@bobmail.bob', 'Jerzy', 'Decapito'),
            new User(69, 'ret', 'bob@bobmail.bob', 'Vivienne', 'Cooper'),
        ];
        const applicants = [
            new Applicant(1, 'Bob', 'Johnson', new Date(), new Resume('Bob_resume.pdf', 'google.com')),
            new Applicant(2, 'Hardware Engineer', 'Easy job easy money', new Date(), new Resume('xd', 'google.com')),
        ];
        const jobs = [
            new JobPosting(1, 'Software Engineer', 'Easy job easy money', 'Millions of cents'),
            new JobPosting(2, 'Hardware Engineer', 'Easy job easy money', '$5345-$53499'),
        ];
        const comments = [
            new Comment(1, users[0], new Date(), 'Cool.'),
            new Comment(2, users[1], new Date(), 'Cool as well.')
        ];
        const processes = [
            new Process(1, jobs[0], applicants[0], 3, comments)
        ];
        const jobsprocesses = [
            processes[0]
        ];
        const applicantsprocesses = [
            processes[0]
        ];

        return { users, applicants, jobs, processes, jobsprocesses, applicantsprocesses, comments };
    }
}

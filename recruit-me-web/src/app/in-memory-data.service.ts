import { InMemoryDbService } from 'angular-in-memory-web-api';
import {Recruiter} from './recruiters/recruiter';

export class InMemoryDataService implements InMemoryDbService {
    createDb() {
        const recruiters = [
            new Recruiter(1, 'bobsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new Recruiter(2, 'anniex', 'bob@bobmail.bob', 'Ann', 'Johnson'),
            new Recruiter(3, 'abcd', 'bob@bobmail.bob', 'John', 'Disculpe'),
            new Recruiter(4, 'dfgdfg', 'bob@bobmail.bob', 'Jerzy', 'Decapito'),
            new Recruiter(5, 'ret', 'bob@bobmail.bob', 'Vivienne', 'Cooper'),
            new Recruiter(6, 'bgsky', 'bob@bobmail.bob', 'Bob', 'Johnson'),
            new Recruiter(7, 'bfbske', 'bob@bobmail.bob', 'Bob', 'Johnson'),
        ];
        return {recruiters};
    }
}

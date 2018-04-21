export class Recruiter {
    constructor(id: Number = null, username: string = null,
                email: string = null, firstName: string = null, lastName: string = null) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    id: Number;
    username: string;
    email: string;
    firstName: string;
    lastName: string;
}

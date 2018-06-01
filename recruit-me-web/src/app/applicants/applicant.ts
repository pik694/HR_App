export class Applicant {
    constructor(id: number = null, firstName: string = null, lastName: string = null, birthDate: Date = null,
                resume: Resume = null, email: string = null, phoneNumber: string = null) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.resume = resume;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    id: number;
    firstName: string;
    lastName: string;
    birthDate: Date;
    resume: Resume;
    email: string;
    phoneNumber: string;
}

export class Resume {
    constructor(name: string, value: string) {
        this.name = name;
        this.value = value;
    }
    name: string;
    value: string; // url if getting from server, base 64 encoded content if sending to server
}
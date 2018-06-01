export class JobPosting {
    constructor(id: number = null, title: string = null, description: string = null, salaryInfo: string = null) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.salaryInfo = salaryInfo;
    }
    id: number;
    title: string;
    description: string;
    salaryInfo: string;
}

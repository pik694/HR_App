import {User} from "../../users/user";

export class Comment {
    constructor(id: number = null, user: User = null, date: Date = null, content: string = null) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.content = content;
    }
    id: number;
    user: User;
    date: Date;
    content: string;
}

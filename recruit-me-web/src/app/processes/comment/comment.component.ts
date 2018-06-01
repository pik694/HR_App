import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Comment} from "./comment";
import {CommentService} from "./comment.service";

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  constructor(private service: CommentService) { }

  @Input() model: Comment;
  backupModel: Comment;
    isCreatingNew: boolean = false;
  @Input() isEditing: boolean = false;
  @Input() processId: number; // if creating new
  modalId: string = CommentComponent.uuidv4();
  ready = false;
  @Output() onCommentDelete = new EventEmitter<Comment>();
  @Output() onCommentCreation = new EventEmitter<Comment>();

  static uuidv4() {
      return 'xxxxxxxxxxxx4xxxyxxxxxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
          var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
          return v.toString(16);
      });
  }

  ngOnInit() {
    if (this.model == null) {
      this.isEditing = this.isCreatingNew = true;
      this.model = new Comment();
    }
    else
      this.backupModel = this.model;
    this.ready=true;
  }

  saveComment() {
    if (this.processId == null)
      this.updateComment();
    else
      this.createComment();
  }

  updateComment() {
      this.service.updateComment(this.model);
      this.isEditing = false;
  }

  createComment() {
    this.service.createCommentForProcess(this.model, this.processId).subscribe(comment =>
    {
      console.log(comment);
      this.onCommentCreation.emit(comment);
    });
    this.model.content = "";
  }

  deleteComment() {
    this.service.deleteComment(this.model);
    this.onCommentDelete.emit(this.model);
  }

  startEditing() {
    this.backupModel = Object.assign({}, this.model);
    this.isEditing = true
  }

  cancelEditing() {
    this.model = Object.assign({}, this.backupModel);
    this.isEditing = false;
  }


}

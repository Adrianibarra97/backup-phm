import { NgIf } from '@angular/common'
import { Component, EventEmitter, Input, Output } from '@angular/core'
import { CommentJSON } from 'src/app/data/models/Comment'
import { UserService } from 'src/app/data/services/user-service/user.service'

@Component({
  selector: 'app-user-comment',
  standalone: true,
  imports: [NgIf],
  templateUrl: './user-comment.component.html',
  styleUrl: './user-comment.component.css'
})
export class UserCommentComponent {
  @Input() comment!: CommentJSON
  @Input() activeDelete!: boolean
  @Output() update: EventEmitter<void> = new EventEmitter<void>()

  constructor(private userService: UserService) {}

  async deleteComment(id: number) {
    await this.userService.deleteComment(id)
    this.update.emit()
  }
}

import { CommentJSON } from 'src/app/data/models/Comment'
import { Show } from 'src/app/data/models/Show'
import { Component, EventEmitter, Input, Output } from '@angular/core'
import { ButtonModule } from 'primeng/button'
import { RouterLink } from '@angular/router'
import { NgFor, NgIf } from '@angular/common'
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms'
import { UserService } from 'src/app/data/services/user-service/user.service'
@Component({
  selector: 'app-show',
  standalone: true,
  imports: [ButtonModule, ReactiveFormsModule, RouterLink, NgIf, NgFor],
  templateUrl: './show.component.html',
  styleUrl: './show.component.css'
})
export class ShowComponent {
  @Input() show!: Show
  @Input() isAuthorized!: boolean
  @Input() isUserPage!: boolean
  @Output() update: EventEmitter<void> = new EventEmitter<void>()
  public canComment: boolean = false
  public commentForm!: FormGroup

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService
  ) {
    this.commentForm = this.formBuilder.group({
      message: ''
    })
  }

  functionsOfShow(): string[] {
    return this.show.functionShow.map(
      (functionShow) =>
        functionShow.hourOfFunction.getDay().toString() +
        '-' +
        functionShow.hourOfFunction.getMonth()
    )
  }

  openCommentForm() {
    this.canComment = true
  }

  async comment() {
    const date: Date = new Date()
    const dateComment =
      date.getFullYear() + '-' + date.getMonth() + '-' + date.getDate()
    const commentJSON: CommentJSON = {
      id: this.show.id,
      bandName: this.show.bandName,
      imageShow: this.show.img,
      description: this.commentForm.value.message,
      score: 3.4,
      dateComment: dateComment
    }

    await this.userService.createCommentToUser(commentJSON)
    this.update.emit()
  }
}

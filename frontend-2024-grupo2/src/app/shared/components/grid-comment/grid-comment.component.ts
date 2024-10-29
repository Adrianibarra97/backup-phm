import { NgFor, NgIf } from '@angular/common'
import { Component, EventEmitter, Input, Output } from '@angular/core'
import { UserCommentComponent } from '../user-comment/user-comment.component'
import { CommentJSON } from 'src/app/data/models/Comment'

@Component({
  selector: 'app-grid-comment',
  standalone: true,
  imports: [UserCommentComponent, NgIf, NgFor],
  templateUrl: './grid-comment.component.html',
  styleUrl: './grid-comment.component.css'
})
export class GridCommentComponent {
  @Input() content: Array<CommentJSON> = []
  @Input() activeDelete!: boolean
  @Output() update: EventEmitter<void> = new EventEmitter<void>()

  gridUpdate() {
    this.update.emit()
  }
}

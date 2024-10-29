import { Component, OnInit } from '@angular/core'
import { CommentJSON } from 'src/app/data/models/Comment'
import { UserService } from 'src/app/data/services/user-service/user.service'
import { GridCommentComponent } from 'src/app/shared/components/grid-comment/grid-comment.component'

@Component({
  selector: 'app-user-profile-comment',
  standalone: true,
  imports: [GridCommentComponent],
  templateUrl: './user-profile-comment.component.html',
  styleUrl: './user-profile-comment.component.css'
})
export class UserProfileCommentComponent implements OnInit {
  public comments: CommentJSON[] = []

  constructor(private userService: UserService) {}

  async ngOnInit(): Promise<void> {
    try {
      this.comments = await this.userService.getComments()
    } catch {
      this.comments = []
    }
  }

  async updateList() {
    try {
      this.comments = await this.userService.getComments()
    } catch {
      this.comments = []
    }
  }
}

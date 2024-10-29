import { UserService } from 'src/app/data/services/user-service/user.service'
import { Component, EventEmitter, Input, Output } from '@angular/core'
import { UserFriendJSON } from 'src/app/data/models/User'

@Component({
  selector: 'app-user-friend',
  standalone: true,
  imports: [],
  templateUrl: './user-friend.component.html',
  styleUrl: './user-friend.component.css'
})
export class UserFriendComponent {
  @Input() friend!: UserFriendJSON
  @Output() update: EventEmitter<void> = new EventEmitter<void>()

  constructor(private userService: UserService) {}

  async deleteFriend(id: number) {
    await this.userService.deleteFriend(id)
    this.update.emit()
  }
}

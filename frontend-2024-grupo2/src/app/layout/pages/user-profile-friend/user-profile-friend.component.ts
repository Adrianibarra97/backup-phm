import { Component, OnInit } from '@angular/core'
import { UserFriendJSON } from 'src/app/data/models/User'
import { UserService } from 'src/app/data/services/user-service/user.service'
import { GridFriendComponent } from 'src/app/shared/components/grid-friend/grid-friend.component'

@Component({
  selector: 'app-user-profile-friend',
  standalone: true,
  imports: [GridFriendComponent],
  templateUrl: './user-profile-friend.component.html',
  styleUrl: './user-profile-friend.component.css'
})
export class UserProfileFriendComponent implements OnInit {
  public friends: UserFriendJSON[] = []

  constructor(private userService: UserService) {}

  async ngOnInit(): Promise<void> {
    try {
      this.friends = await this.userService.getFriend()
    } catch {
      this.friends = []
    }
  }

  async updateList() {
    try {
      this.friends = await this.userService.getFriend()
    } catch {
      this.friends = []
    }
  }
}

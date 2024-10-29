import { Component, OnInit } from '@angular/core'
import { Show } from 'src/app/data/models/Show'
import { UserService } from 'src/app/data/services/user-service/user.service'
import { GridComponent } from 'src/app/shared/components/grid/grid.component'

@Component({
  selector: 'app-user-profile-show',
  standalone: true,
  imports: [GridComponent],
  templateUrl: './user-profile-show.component.html',
  styleUrl: './user-profile-show.component.css'
})
export class UserProfileShowComponent implements OnInit {
  public shows: Show[] = []
  public isAuthorized: boolean = false
  public isUserPage: boolean = true

  constructor(private userService: UserService) {}

  async ngOnInit(): Promise<void> {
    try {
      this.shows = await this.userService.getShows()
    } catch {
      this.shows = []
    }
  }

  async updateList() {
    try {
      this.shows = await this.userService.getShows()
    } catch {
      this.shows = []
    }
  }
}

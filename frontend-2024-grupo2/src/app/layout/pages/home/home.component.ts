import { Component, OnInit } from '@angular/core'
import { FilterShowJSON, Show } from 'src/app/data/models/Show'
import { AuthService } from 'src/app/data/services/auth-service/auth.service'
import { ShowService } from 'src/app/data/services/show-service/show.service'
import { GridComponent } from 'src/app/shared/components/grid/grid.component'
import { SearchBarComponent } from 'src/app/shared/components/search-bar/search-bar.component'

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [SearchBarComponent, GridComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  public shows: Show[] = []
  public isAuthorized: boolean = false
  public isUserPage: boolean = false
  public filterShowJSON: FilterShowJSON = {
    bandName: '',
    location: '',
    byFriends: false
  }

  constructor(
    private showService: ShowService,
    private auth: AuthService
  ) {}

  async searchShowsBy(event: FilterShowJSON): Promise<void> {
    try {
      this.filterShowJSON = event
      this.shows = await this.showService.getShowsFilterBy(this.filterShowJSON)
    } catch {
      this.shows = []
    }
  }

  async ngOnInit() {
    try {
      this.shows = await this.showService.getAll()
      this.isAuthorized = this.auth.isAuthorized()
    } catch {
      this.shows = []
    }
  }
}

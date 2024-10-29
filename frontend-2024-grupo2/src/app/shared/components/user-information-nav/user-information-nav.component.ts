import { Component } from '@angular/core'
import { RouterLink, RouterLinkActive } from '@angular/router'

@Component({
  selector: 'app-user-information-nav',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './user-information-nav.component.html',
  styleUrls: ['./user-information-nav.component.css']
})
export class UserInformationNavComponent {}

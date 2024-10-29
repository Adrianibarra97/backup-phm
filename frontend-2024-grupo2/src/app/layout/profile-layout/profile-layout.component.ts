import { RouterOutlet } from '@angular/router'
import { Component } from '@angular/core'
import { GridComponent } from 'src/app/shared/components/grid/grid.component'
import { UserBannerComponent } from 'src/app/shared/components/user-banner/user-banner.component'
import { UserInformationNavComponent } from 'src/app/shared/components/user-information-nav/user-information-nav.component'

@Component({
  selector: 'app-profile-layout',
  standalone: true,
  imports: [
    RouterOutlet,
    UserBannerComponent,
    UserInformationNavComponent,
    GridComponent
  ],
  templateUrl: './profile-layout.component.html',
  styleUrl: './profile-layout.component.css'
})
export class ProfileLayoutComponent {}

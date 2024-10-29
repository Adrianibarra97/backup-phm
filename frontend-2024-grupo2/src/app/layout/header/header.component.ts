import { NgIf } from '@angular/common'
import { Component, OnInit } from '@angular/core'
import { ActivatedRoute, Router, RouterLink } from '@angular/router'
import { UserLoggedJSON } from 'src/app/data/models/User'
import { AuthService } from 'src/app/data/services/auth-service/auth.service'

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterLink, NgIf],
  providers: [
    {
      provide: ActivatedRoute,
      useValue: ActivatedRoute
    }
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit {
  public userData!: UserLoggedJSON

  constructor(
    private auth: AuthService,
    private router: Router
  ) {}

  isAuthorized(): boolean {
    return this.auth.isAuthorized()
  }

  isNotAdimistrator(): boolean {
    return !this.auth.isAdministrator()
  }

  shoppingCartRedirect() {
    if (this.auth.isAuthorized()) {
      return this.router.navigateByUrl('/shopping-cart')
    }
    return this.router.navigateByUrl('/auth/login')
  }

  redirectProfile() {
    if (this.auth.isAuthorized()) {
      if (this.auth.isAdministrator()) {
        return this.router.navigateByUrl('/admin-dashboard')
      }

      if (this.auth.isConsumer()) {
        return this.router.navigateByUrl('/profile/user-show')
      }
    }
    return this.router.navigateByUrl('/auth/login')
  }

  logout() {
    this.auth.logout()
  }

  async ngOnInit(): Promise<void> {
    this.userData = await this.auth.getUserDataToHeader()
  }
}

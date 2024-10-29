import { NgModule } from '@angular/core'
import { BrowserModule } from '@angular/platform-browser'
import {
  BrowserAnimationsModule,
  provideAnimations
} from '@angular/platform-browser/animations'

import { AppRoutingModule } from './app-routing.module'
import { AppComponent } from './app.component'

import { AuthLayoutComponent } from './layout/auth-layout/auth-layout.component'
import { MainLayoutComponent } from './layout/main-layout/main-layout.component'
import { ProfileLayoutComponent } from './layout/profile-layout/profile-layout.component'
import { AdminDashboardComponent } from './layout/pages/admin-dashboard/admin-dashboard.component'
import { UserDetailShowComponent } from './layout/pages/user-detail-show/user-detail-show.component'
import { UserProfileCommentComponent } from './layout/pages/user-profile-comment/user-profile-comment.component'
import { UserProfileFriendComponent } from './layout/pages/user-profile-friend/user-profile-friend.component'
import { UserProfileShowComponent } from './layout/pages/user-profile-show/user-profile-show.component'
import { HomeComponent } from './layout/pages/home/home.component'
import { ShoppingCartComponent } from './layout/pages/shopping-cart/shopping-cart.component'
import { AuthLoginComponent } from './layout/pages/auth-login/auth-login.component'
import { AuthRegisterComponent } from './layout/pages/auth-register/auth-register.component'
import { AuthRestorePasswordComponent } from './layout/pages/auth-restore-password/auth-restore-password.component'
import { UserBannerComponent } from './shared/components/user-banner/user-banner.component'
import { UserInformationNavComponent } from './shared/components/user-information-nav/user-information-nav.component'
import { provideHttpClient, withFetch } from '@angular/common/http'
import { UserService } from './data/services/user-service/user.service'
import { AuthService } from './data/services/auth-service/auth.service'
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { CommonModule } from '@angular/common'
import { ToastrModule, provideToastr } from 'ngx-toastr'
import { ErrorHandler } from './util/ErrorHandler'
import { TicketsConsumerInformationComponent } from './shared/components/tickets-consumer-information/tickets-consumer-information.component'
import { AdminInformationComponent } from './shared/components/admin-information/admin-information.component'

@NgModule({
  declarations: [AppComponent],
  imports: [
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    CommonModule,
    ToastrModule.forRoot(),
    AuthLayoutComponent,
    MainLayoutComponent,
    ProfileLayoutComponent,
    HomeComponent,
    AdminDashboardComponent,
    UserDetailShowComponent,
    UserProfileCommentComponent,
    UserProfileFriendComponent,
    UserProfileShowComponent,
    ShoppingCartComponent,
    AuthLoginComponent,
    AuthRegisterComponent,
    AuthRestorePasswordComponent,
    UserBannerComponent,
    UserInformationNavComponent,
    TicketsConsumerInformationComponent,
    AdminInformationComponent
  ],
  providers: [
    provideHttpClient(withFetch()),
    provideAnimations(),
    provideToastr(),
    { provide: UserService, useClass: UserService },
    { provide: AuthService, useClass: AuthService },
    { provide: ErrorHandler, useClass: ErrorHandler }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}

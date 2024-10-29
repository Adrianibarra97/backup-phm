import { NgModule } from '@angular/core'
import { RouterModule, Routes } from '@angular/router'
import { AuthLayoutComponent } from './layout/auth-layout/auth-layout.component'
import { MainLayoutComponent } from './layout/main-layout/main-layout.component'
import { AuthLoginComponent } from './layout/pages/auth-login/auth-login.component'
import { AuthRegisterComponent } from './layout/pages/auth-register/auth-register.component'
import { AuthRestorePasswordComponent } from './layout/pages/auth-restore-password/auth-restore-password.component'
import { HomeComponent } from './layout/pages/home/home.component'
import { ProfileLayoutComponent } from './layout/profile-layout/profile-layout.component'
import { UserProfileCommentComponent } from './layout/pages/user-profile-comment/user-profile-comment.component'
import { UserProfileFriendComponent } from './layout/pages/user-profile-friend/user-profile-friend.component'
import { UserProfileShowComponent } from './layout/pages/user-profile-show/user-profile-show.component'
import { NotFoundComponent } from './layout/pages/not-found/not-found.component'
import { AdminDashboardComponent } from './layout/pages/admin-dashboard/admin-dashboard.component'
import { UserDetailShowComponent } from './layout/pages/user-detail-show/user-detail-show.component'
import { ShoppingCartComponent } from './layout/pages/shopping-cart/shopping-cart.component'
import { authGuard } from './core/guards/auth.guard'
import { consumerGuard } from './core/guards/consumer.guard'
import { adminGuard } from './core/guards/admin.guard'

const routes: Routes = [
  {
    path: 'auth',
    component: AuthLayoutComponent,
    children: [
      { path: 'login', component: AuthLoginComponent },
      { path: 'register', component: AuthRegisterComponent },
      { path: 'restore', component: AuthRestorePasswordComponent }
    ]
  },
  {
    path: '',
    component: MainLayoutComponent,
    children: [
      { path: 'home', component: HomeComponent },
      {
        path: 'profile',
        canActivate: [authGuard, consumerGuard],
        component: ProfileLayoutComponent,
        children: [
          { path: 'user-comment', component: UserProfileCommentComponent },
          { path: 'user-friend', component: UserProfileFriendComponent },
          { path: 'user-show', component: UserProfileShowComponent }
        ]
      },
      {
        path: 'shopping-cart',
        canActivate: [authGuard, consumerGuard],
        component: ShoppingCartComponent
      },
      {
        path: 'admin-dashboard',
        component: AdminDashboardComponent,
        canActivate: [authGuard, adminGuard]
      },
      {
        path: 'user-detail/:id',
        canActivate: [authGuard],
        component: UserDetailShowComponent
      },
      { path: '', redirectTo: 'home', pathMatch: 'full' }
    ]
  },
  {
    path: 'error',
    component: AuthLayoutComponent,
    children: [
      {
        path: 'not-found',
        component: NotFoundComponent
      }
    ]
  },
  { path: '**', redirectTo: 'error/not-found', pathMatch: 'full' }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}

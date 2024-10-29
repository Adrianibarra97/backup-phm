import { inject } from '@angular/core'
import { CanActivateFn, Router } from '@angular/router'
import { AuthService } from 'src/app/data/services/auth-service/auth.service'

export const authGuard: CanActivateFn = async () => {
  if (!inject(AuthService).isAuthorized()) {
    inject(Router).navigateByUrl('/auth/login')
    return false
  }
  return true
}

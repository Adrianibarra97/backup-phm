import { inject } from '@angular/core'
import { CanActivateFn, Router } from '@angular/router'
import { ToastrService } from 'ngx-toastr'
import { AuthService } from 'src/app/data/services/auth-service/auth.service'

export const adminGuard: CanActivateFn = () => {
  if (!inject(AuthService).isAdministrator()) {
    inject(ToastrService).error(
      'No tiene los permisos suficientes para acceder!',
      'Error'
    )
    inject(Router).navigateByUrl('/home')
    return false
  }
  return true
}

import { HttpErrorResponse } from '@angular/common/http'
import { Injectable } from '@angular/core'
import { Router } from '@angular/router'
import { ToastrService } from 'ngx-toastr'
import {
  NotConectionError,
  NotFoundError,
  ServerError,
  UnauthorizedError,
  ValidationError
} from '../data/models/CustomError'

@Injectable({
  providedIn: 'root'
})
export class ErrorHandler {
  constructor(
    private toastr: ToastrService,
    private router: Router
  ) {}

  errorHandler(error: unknown) {
    if (error instanceof HttpErrorResponse) {
      if (error.status == 0) {
        this.router.navigateByUrl('/error/not-found')
        this.toastr.error('Error en la conexión al servidor.', 'Error')
        throw new NotConectionError('Error en la conexión al servidor.')
      }

      if (error.status == 400) {
        this.toastr.error('Error al acceder al recurso.', 'Error')
        throw new ValidationError('Error en la conexión al servidor.')
      }

      if (error.status == 401) {
        this.toastr.error('No tiene permisos para acceder.', 'Error')
        throw new UnauthorizedError('Error en la conexión al servidor.')
      }

      if (error.status == 404) {
        this.toastr.error('No se encontró el recurso solicitado.', 'Error')
        throw new NotFoundError('Error en la conexión al servidor.')
      }

      if (error.status == 500) {
        this.toastr.error('Error en el servidor', 'Error')
        throw new ServerError('Error en la conexión al servidor.')
      }
    }
  }
}

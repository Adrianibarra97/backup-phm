import { TestBed } from '@angular/core/testing'
import { UserService } from './user.service'
import { userHttpClientSpy } from './userHttpClientSpy'
import { HttpClient } from '@angular/common/http'
import { AuthService } from '../auth-service/auth.service'
import { ToastrService, provideToastr } from 'ngx-toastr'

describe('UserService', () => {
  let service: UserService

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        { provide: HttpClient, useValue: userHttpClientSpy },
        { provide: UserService, useClass: UserService },
        { provide: AuthService, useClass: AuthService },
        { provide: ToastrService, useValue: provideToastr() }
      ]
    })
    service = TestBed.inject(UserService)
  })

  it('should be created', () => {
    expect(service).toBeTruthy()
  })
})

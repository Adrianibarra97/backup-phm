import { ComponentFixture, TestBed } from '@angular/core/testing'

import { AuthLoginComponent } from './auth-login.component'
import { HttpClient } from '@angular/common/http'
import { userHttpClientSpy } from 'src/app/data/services/user-service/userHttpClientSpy'
import { AuthService } from 'src/app/data/services/auth-service/auth.service'
import { ToastrService, provideToastr } from 'ngx-toastr'

describe('AuthLoginComponent', () => {
  let component: AuthLoginComponent
  let fixture: ComponentFixture<AuthLoginComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AuthLoginComponent],
      providers: [
        { provide: HttpClient, useValue: userHttpClientSpy },
        { provide: AuthService, useClass: AuthService },
        { provide: ToastrService, useValue: provideToastr() }
      ]
    }).compileComponents()

    fixture = TestBed.createComponent(AuthLoginComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

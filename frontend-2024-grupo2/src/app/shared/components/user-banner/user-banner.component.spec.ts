import { ComponentFixture, TestBed } from '@angular/core/testing'
import { UserBannerComponent } from './user-banner.component'
import { UserService } from 'src/app/data/services/user-service/user.service'
import { AuthService } from 'src/app/data/services/auth-service/auth.service'
import { HttpClient } from '@angular/common/http'
import { userHttpClientSpy } from 'src/app/data/services/user-service/userHttpClientSpy'
import { User } from 'src/app/data/models/User'
import { ToastrService, provideToastr } from 'ngx-toastr'

describe('UserBannerComponent', () => {
  let component: UserBannerComponent
  let fixture: ComponentFixture<UserBannerComponent>
  const user: User = User.fromJSON({
    name: 'Adrian',
    surname: 'Ibarra',
    username: 'adri123',
    imageURL: '',
    country: 'Argentina',
    birthOfDate: '1997-3-23',
    dni: 3242344,
    password: 0,
    availableMoney: 12.0,
    role: {
      name: 'Consumer',
      isAdministrator: false
    }
  })

  beforeEach(async () => {
    TestBed.configureTestingModule({
      imports: [UserBannerComponent],
      providers: [
        { provide: HttpClient, useValue: userHttpClientSpy },
        { provide: UserService, useClass: UserService },
        { provide: AuthService, useClass: AuthService },
        { provide: ToastrService, useValue: provideToastr() }
      ]
    })
    fixture = TestBed.createComponent(UserBannerComponent)
    component = fixture.componentInstance
    component.user = user
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

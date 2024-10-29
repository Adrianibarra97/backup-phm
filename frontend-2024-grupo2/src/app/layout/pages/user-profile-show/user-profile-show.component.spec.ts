import { ComponentFixture, TestBed } from '@angular/core/testing'

import { UserProfileShowComponent } from './user-profile-show.component'
import { HttpClient } from '@angular/common/http'
import { userHttpClientSpy } from 'src/app/data/services/user-service/userHttpClientSpy'
import { UserService } from 'src/app/data/services/user-service/user.service'
import { ToastrService, provideToastr } from 'ngx-toastr'

describe('UserProfileShowComponent', () => {
  let component: UserProfileShowComponent
  let fixture: ComponentFixture<UserProfileShowComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserProfileShowComponent],
      providers: [
        {
          provide: HttpClient,
          useValue: userHttpClientSpy
        },
        {
          provide: UserService,
          useClass: UserService
        },
        {
          provide: ToastrService,
          useValue: provideToastr()
        }
      ]
    }).compileComponents()

    fixture = TestBed.createComponent(UserProfileShowComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

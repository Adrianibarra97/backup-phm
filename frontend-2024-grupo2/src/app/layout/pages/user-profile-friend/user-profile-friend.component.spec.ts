import { ComponentFixture, TestBed } from '@angular/core/testing'

import { UserProfileFriendComponent } from './user-profile-friend.component'
import { HttpClient } from '@angular/common/http'
import { userHttpClientSpy } from 'src/app/data/services/user-service/userHttpClientSpy'
import { UserService } from 'src/app/data/services/user-service/user.service'
import { ToastrService, provideToastr } from 'ngx-toastr'

describe('UserProfileFriendComponent', () => {
  let component: UserProfileFriendComponent
  let fixture: ComponentFixture<UserProfileFriendComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserProfileFriendComponent],
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

    fixture = TestBed.createComponent(UserProfileFriendComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

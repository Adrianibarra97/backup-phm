import { ComponentFixture, TestBed } from '@angular/core/testing'

import { UserFriendComponent } from './user-friend.component'
import { HttpClient } from '@angular/common/http'
import { userHttpClientSpy } from 'src/app/data/services/user-service/userHttpClientSpy'
import { UserService } from 'src/app/data/services/user-service/user.service'
import { UserFriendJSON } from 'src/app/data/models/User'
import { ToastrService, provideToastr } from 'ngx-toastr'

describe('UserFriendComponent', () => {
  let component: UserFriendComponent
  let fixture: ComponentFixture<UserFriendComponent>
  const friend: UserFriendJSON = {
    id: 0,
    name: 'Adrian',
    country: 'Argentina',
    image: 'https://image.com/adrian'
  }

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserFriendComponent],
      providers: [
        { provide: HttpClient, useValue: userHttpClientSpy },
        { provide: UserService, useClass: UserService },
        { provide: ToastrService, useValue: provideToastr() }
      ]
    }).compileComponents()

    fixture = TestBed.createComponent(UserFriendComponent)
    component = fixture.componentInstance
    component.friend = friend
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

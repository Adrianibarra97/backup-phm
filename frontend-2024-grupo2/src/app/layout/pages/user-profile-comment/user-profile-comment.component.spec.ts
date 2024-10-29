import { ComponentFixture, TestBed } from '@angular/core/testing'

import { UserProfileCommentComponent } from './user-profile-comment.component'
import { HttpClient } from '@angular/common/http'
import { userHttpClientSpy } from 'src/app/data/services/user-service/userHttpClientSpy'
import { UserService } from 'src/app/data/services/user-service/user.service'
import { ToastrService, provideToastr } from 'ngx-toastr'

describe('UserProfileCommentComponent', () => {
  let component: UserProfileCommentComponent
  let fixture: ComponentFixture<UserProfileCommentComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserProfileCommentComponent],
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

    fixture = TestBed.createComponent(UserProfileCommentComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

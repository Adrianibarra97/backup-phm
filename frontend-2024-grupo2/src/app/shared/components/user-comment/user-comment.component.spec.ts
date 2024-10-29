import { ComponentFixture, TestBed } from '@angular/core/testing'

import { UserCommentComponent } from './user-comment.component'
import { CommentJSON } from 'src/app/data/models/Comment'
import { HttpClient } from '@angular/common/http'
import { userHttpClientSpy } from 'src/app/data/services/user-service/userHttpClientSpy'
import { ToastrService, provideToastr } from 'ngx-toastr'

describe('UserCommentComponent', () => {
  let component: UserCommentComponent
  let fixture: ComponentFixture<UserCommentComponent>
  const comment: CommentJSON = {
    id: 1,
    bandName: '',
    imageShow: '',
    description: '',
    score: 3.5,
    dateComment: ''
  }

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserCommentComponent],
      providers: [
        { provide: HttpClient, useValue: userHttpClientSpy },
        { provide: ToastrService, useValue: provideToastr() }
      ]
    }).compileComponents()

    fixture = TestBed.createComponent(UserCommentComponent)
    component = fixture.componentInstance
    component.comment = comment
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

import { ComponentFixture, TestBed } from '@angular/core/testing'

import { ShowFormComponent } from './show-form.component'
import { ShowService } from 'src/app/data/services/show-service/show.service'
import { HttpClient } from '@angular/common/http'
import { userHttpClientSpy } from 'src/app/data/services/user-service/userHttpClientSpy'
import { AuthService } from 'src/app/data/services/auth-service/auth.service'
import { ToastrService, provideToastr } from 'ngx-toastr'

describe('ShowFormComponent', () => {
  let component: ShowFormComponent
  let fixture: ComponentFixture<ShowFormComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShowFormComponent],
      providers: [
        { provide: HttpClient, useValue: userHttpClientSpy },
        { provide: ShowService, useClass: ShowService },
        { provide: AuthService, useClass: AuthService },
        { provide: ToastrService, useValue: provideToastr() }
      ]
    }).compileComponents()

    fixture = TestBed.createComponent(ShowFormComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

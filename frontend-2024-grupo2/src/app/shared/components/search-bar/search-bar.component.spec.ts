import { ComponentFixture, TestBed } from '@angular/core/testing'

import { SearchBarComponent } from './search-bar.component'
import { HttpClient } from '@angular/common/http'
import { userHttpClientSpy } from 'src/app/data/services/user-service/userHttpClientSpy'
import { AuthService } from 'src/app/data/services/auth-service/auth.service'
import { ToastrService, provideToastr } from 'ngx-toastr'

describe('SearchBarComponent', () => {
  let component: SearchBarComponent
  let fixture: ComponentFixture<SearchBarComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SearchBarComponent],
      providers: [
        { provide: HttpClient, useValue: userHttpClientSpy },
        { provide: AuthService, useClass: AuthService },
        { provide: ToastrService, useValue: provideToastr() }
      ]
    }).compileComponents()

    fixture = TestBed.createComponent(SearchBarComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

import { ComponentFixture, TestBed } from '@angular/core/testing'
import { ProfileLayoutComponent } from './profile-layout.component'
import { ActivatedRoute } from '@angular/router'
import { HttpClient } from '@angular/common/http'
import { userHttpClientSpy } from 'src/app/data/services/user-service/userHttpClientSpy'
import { ToastrService, provideToastr } from 'ngx-toastr'

describe('ProfileLayoutComponent', () => {
  let component: ProfileLayoutComponent
  let fixture: ComponentFixture<ProfileLayoutComponent>
  // const user: User = User.fromJSON({
  //   name: 'Adrian',
  //   surname: 'Ibarra',
  //   username: 'adri123',
  //   imageURL: '',
  //   country: 'Argentina',
  //   birthOfDate: '1997-3-23',
  //   dni: 3242344,
  //   password: 0,
  //   availableMoney: 12.0
  // })

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [],
      providers: [
        { provide: HttpClient, useValue: userHttpClientSpy },
        { provide: ActivatedRoute, useValue: ActivatedRoute },
        { provide: ToastrService, useValue: provideToastr() }
      ]
    }).compileComponents()

    fixture = TestBed.createComponent(ProfileLayoutComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

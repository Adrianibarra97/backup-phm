import { ComponentFixture, TestBed } from '@angular/core/testing'

import { MainLayoutComponent } from './main-layout.component'
import { AppRoutingModule } from 'src/app/app-routing.module'
import { HttpClient } from '@angular/common/http'
import { userHttpClientSpy } from 'src/app/data/services/user-service/userHttpClientSpy'
import { ToastrService, provideToastr } from 'ngx-toastr'

describe('MainLayoutComponent', () => {
  let component: MainLayoutComponent
  let fixture: ComponentFixture<MainLayoutComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppRoutingModule, MainLayoutComponent],
      providers: [
        { provide: HttpClient, useValue: userHttpClientSpy },
        { provide: ToastrService, useValue: provideToastr() }
      ]
    }).compileComponents()

    fixture = TestBed.createComponent(MainLayoutComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

import { ComponentFixture, TestBed } from '@angular/core/testing'

import { AdminDashboardComponent } from './admin-dashboard.component'
import { HttpClient } from '@angular/common/http'
import { userHttpClientSpy } from 'src/app/data/services/user-service/userHttpClientSpy'
import { ToastrService, provideToastr } from 'ngx-toastr'

describe('AdminDashboardComponent', () => {
  let component: AdminDashboardComponent
  let fixture: ComponentFixture<AdminDashboardComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdminDashboardComponent],
      providers: [
        { provide: HttpClient, useValue: userHttpClientSpy },
        { provide: ToastrService, useValue: provideToastr() }
      ]
    }).compileComponents()

    fixture = TestBed.createComponent(AdminDashboardComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

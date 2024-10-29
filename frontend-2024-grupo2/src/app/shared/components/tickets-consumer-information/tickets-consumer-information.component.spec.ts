import { ComponentFixture, TestBed } from '@angular/core/testing'

import { TicketsConsumerInformationComponent } from './tickets-consumer-information.component'
import { HttpClient } from '@angular/common/http'
import { userHttpClientSpy } from 'src/app/data/services/user-service/userHttpClientSpy'
import { ToastrService, provideToastr } from 'ngx-toastr'
import { ActivatedRoute } from '@angular/router'

describe('TicketsConsumerInformationComponent', () => {
  let component: TicketsConsumerInformationComponent
  let fixture: ComponentFixture<TicketsConsumerInformationComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TicketsConsumerInformationComponent],
      providers: [
        { provide: HttpClient, useValue: userHttpClientSpy },
        { provide: ActivatedRoute, useValue: ActivatedRoute },
        { provide: ToastrService, useValue: provideToastr() }
      ]
    })
    .compileComponents()
    
    fixture = TestBed.createComponent(TicketsConsumerInformationComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

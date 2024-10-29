import { TestBed } from '@angular/core/testing'

import { ShowService } from './show.service'
import { HttpClient } from '@angular/common/http'
import { userHttpClientSpy } from '../user-service/userHttpClientSpy'
import { ToastrService, provideToastr } from 'ngx-toastr'

describe('ShowService', () => {
  let service: ShowService

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [],
      providers: [
        { provide: HttpClient, useValue: userHttpClientSpy },
        { provide: ShowService, useClass: ShowService },
        { provide: ToastrService, useValue: provideToastr() }
      ]
    })
    service = TestBed.inject(ShowService)
  })

  it('should be created', () => {
    expect(service).toBeTruthy()
  })
})

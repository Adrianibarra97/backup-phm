import { ComponentFixture, TestBed } from '@angular/core/testing'

import { ShowAdministratorComponent } from './show-administrator.component'
import { Show } from 'src/app/data/models/Show'
import { HttpClient } from '@angular/common/http'
import { userHttpClientSpy } from 'src/app/data/services/user-service/userHttpClientSpy'
import { ToastrService, provideToastr } from 'ngx-toastr'
import { ActivatedRoute } from '@angular/router'

describe('ShowAdministratorComponent', () => {
  let component: ShowAdministratorComponent
  let fixture: ComponentFixture<ShowAdministratorComponent>
  const show: Show = Show.fromJSON({
    id: 0,
    bandName: 'Iron Maiden',
    placeOfShow: {
      name: 'Estadio único Diego',
      mapLocation: {
        longitud: -57.989028,
        latitud: -34.91375
      },
      fixedCost: 150000.0,
      type: 'Stadium',
      ticketTypes: []
    },
    nameOfRecital: 'Fear of the dark',
    img: 'assets/iron-maiden.jpg',
    status: {
      name: 'PrecioBase',
      profitStatusShowType: 1.8
    },
    costBand: 100000.0,
    functionShow: [],
    friendWithShow: [],
    score: 1.0,
    amountOfComments: 1,
    maxPrice: 10.8,
    minPrice: 9.9,
    userCommented: false,
    ticketPriceForUser: 23
  })

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShowAdministratorComponent],
      providers: [
        { provide: HttpClient, useValue: userHttpClientSpy },
        { provide: ActivatedRoute, useValue: ActivatedRoute },
        { provide: ToastrService, useValue: provideToastr() }
      ]
    }).compileComponents()

    fixture = TestBed.createComponent(ShowAdministratorComponent)
    component = fixture.componentInstance
    component.show = show
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

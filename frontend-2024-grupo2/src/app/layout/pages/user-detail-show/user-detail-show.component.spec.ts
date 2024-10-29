import { AdministratorData } from 'src/app/data/models/AdministratorData'
import { ComponentFixture, TestBed } from '@angular/core/testing'

import { UserDetailShowComponent } from './user-detail-show.component'
import { HttpClient } from '@angular/common/http'
import { userHttpClientSpy } from 'src/app/data/services/user-service/userHttpClientSpy'
import { ActivatedRoute } from '@angular/router'
import { Show } from 'src/app/data/models/Show'
import { ToastrService, provideToastr } from 'ngx-toastr'

describe('UserDetailShowComponent', () => {
  let component: UserDetailShowComponent
  let fixture: ComponentFixture<UserDetailShowComponent>
  const show: Show = Show.fromJSON({
    id: 0,
    bandName: 'AC-DC',
    placeOfShow: {
      name: 'Estadio River Plate',
      mapLocation: {
        longitud: -58.449722222222,
        latitud: -34.545277777778
      },
      fixedCost: 80000.0,
      type: 'Stadium',
      ticketTypes: [
        {
          seatType: {
            name: 'Platea Alta',
            availableCapacity: 4999
          },
          price: 216.9
        },
        {
          seatType: {
            name: 'Campo',
            availableCapacity: 6999
          },
          price: 217.44
        },
        {
          seatType: {
            name: 'Palco',
            availableCapacity: 7999
          },
          price: 217.8
        }
      ]
    },
    nameOfRecital: 'Power up Tour',
    img: 'assets/acdc.jpg',
    status: {
      name: 'PrecioBase',
      profitStatusShowType: 1.8
    },
    costBand: 2400000.0,
    functionShow: [
      {
        id: 0,
        dayOfFunction: '2024-12-01',
        hourOfFunction: '2024-04-01T19:00',
        isSoldDout: false,
        availableSeatTypeList: []
      },
      {
        id: 1,
        dayOfFunction: '2024-12-02',
        hourOfFunction: '2024-04-01T20:00',
        isSoldDout: false,
        availableSeatTypeList: []
      },
      {
        id: 2,
        dayOfFunction: '2024-12-03',
        hourOfFunction: '2024-04-01T21:00',
        isSoldDout: false,
        availableSeatTypeList: []
      }
    ],
    friendWithShow: [],
    score: 5.0,
    amountOfComments: 2,
    maxPrice: 217.8,
    minPrice: 216.9,
    userCommented: false,
    ticketPriceForUser: 23.3
  })
  const administratorData: AdministratorData = new AdministratorData(
    0,
    [],
    0,
    0,
    0,
    0,
    0
  )

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserDetailShowComponent],
      providers: [
        { provide: HttpClient, useValue: userHttpClientSpy },
        { provide: ActivatedRoute, useValue: ActivatedRoute },
        { provide: ToastrService, useValue: provideToastr() }
      ]
    }).compileComponents()

    fixture = TestBed.createComponent(UserDetailShowComponent)
    component = fixture.componentInstance
    component.show = show
    component.administratorData = administratorData
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

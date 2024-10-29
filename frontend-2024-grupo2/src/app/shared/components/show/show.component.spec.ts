import { ComponentFixture, TestBed } from '@angular/core/testing'

import { ShowComponent } from './show.component'
import { Show } from 'src/app/data/models/Show'
import { ActivatedRoute } from '@angular/router'
import { HttpClient } from '@angular/common/http'
import { userHttpClientSpy } from 'src/app/data/services/user-service/userHttpClientSpy'
import { ToastrService, provideToastr } from 'ngx-toastr'

describe('ShowComponent', () => {
  let component: ShowComponent
  let fixture: ComponentFixture<ShowComponent>
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
      imports: [ShowComponent],
      providers: [
        { provide: ActivatedRoute, useValue: ActivatedRoute },
        { provide: HttpClient, useValue: userHttpClientSpy },
        { provide: ToastrService, useValue: provideToastr() }
      ]
    }).compileComponents()

    fixture = TestBed.createComponent(ShowComponent)
    component = fixture.componentInstance
    component.show = show
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })

  it('The name of the band is Iron Maden', () => {
    const name = component.show.bandName
    const showBandName = fixture.debugElement.nativeElement.querySelector(
      '[data-testid = "showBandName"]'
    )
    expect(showBandName.textContent).toBe(name)
  })

  it('The name of the placeOfShow is Estadio único Diego', () => {
    const name = component.show.placeOfShow.name
    const placeOfShowName = fixture.debugElement.nativeElement.querySelector(
      '[data-testid = "placeOfShowName"]'
    )
    expect(placeOfShowName.textContent).toBe('Ubicacion: ' + name)
  })

  it('The score of the show is 1', () => {
    const score = component.show.score
    const showScore = fixture.debugElement.nativeElement.querySelector(
      '[data-testid = "showScore"]'
    )
    expect(showScore.textContent).toBe('' + score)
  })

  it('The range of tickets price is between 9.9 to 10.8 ', () => {
    const rangePrice = component.show.score
    const showRangePrice = fixture.debugElement.nativeElement.querySelector(
      '[data-testid = "showRangePrice"]'
    )
    expect(showRangePrice.textContent).toBe('Desde 9.9 hasta 10.8', rangePrice)
  })
})

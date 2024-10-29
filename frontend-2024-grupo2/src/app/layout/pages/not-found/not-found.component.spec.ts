import { ComponentFixture, TestBed } from '@angular/core/testing'

import { NotFoundComponent } from './not-found.component'
import { AppRoutingModule } from 'src/app/app-routing.module'

describe('NotFoundComponent', () => {
  let component: NotFoundComponent
  let fixture: ComponentFixture<NotFoundComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppRoutingModule, NotFoundComponent]
    }).compileComponents()

    fixture = TestBed.createComponent(NotFoundComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

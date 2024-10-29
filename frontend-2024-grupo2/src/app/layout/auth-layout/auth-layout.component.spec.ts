import { ComponentFixture, TestBed } from '@angular/core/testing'

import { AuthLayoutComponent } from './auth-layout.component'
import { AppRoutingModule } from 'src/app/app-routing.module'

describe('AuthLayoutComponent', () => {
  let component: AuthLayoutComponent
  let fixture: ComponentFixture<AuthLayoutComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppRoutingModule, AuthLayoutComponent]
    }).compileComponents()

    fixture = TestBed.createComponent(AuthLayoutComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

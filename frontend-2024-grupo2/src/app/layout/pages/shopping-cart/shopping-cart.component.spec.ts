import { ComponentFixture, TestBed } from '@angular/core/testing'

import { ShoppingCartComponent } from './shopping-cart.component'
import { HttpClient } from '@angular/common/http'
import { userHttpClientSpy } from 'src/app/data/services/user-service/userHttpClientSpy'
import { ToastrService, provideToastr } from 'ngx-toastr'
import { AuthService } from 'src/app/data/services/auth-service/auth.service'

describe('ShoppingCartComponent', () => {
  let component: ShoppingCartComponent
  let fixture: ComponentFixture<ShoppingCartComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShoppingCartComponent],
      providers: [
        { provide: HttpClient, useValue: userHttpClientSpy },
        { provide: AuthService, useClass: AuthService },
        { provide: ToastrService, useValue: provideToastr() }
      ]
    }).compileComponents()

    fixture = TestBed.createComponent(ShoppingCartComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

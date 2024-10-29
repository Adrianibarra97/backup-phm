import { ComponentFixture, TestBed } from '@angular/core/testing'

import { FunctionShowFormComponent } from './function-show-form.component'
import { ToastrService, provideToastr } from 'ngx-toastr'

describe('FunctionShowFormComponent', () => {
  let component: FunctionShowFormComponent
  let fixture: ComponentFixture<FunctionShowFormComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FunctionShowFormComponent],
      providers: [{ provide: ToastrService, useValue: provideToastr() }]
    }).compileComponents()

    fixture = TestBed.createComponent(FunctionShowFormComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

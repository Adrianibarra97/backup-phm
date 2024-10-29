import { ComponentFixture, TestBed } from '@angular/core/testing'

import { AdminInformationComponent } from './admin-information.component'
import { AdministratorData } from 'src/app/data/models/AdministratorData'

describe('AdminInformationComponent', () => {
  let component: AdminInformationComponent
  let fixture: ComponentFixture<AdminInformationComponent>
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
      imports: [AdminInformationComponent]
    }).compileComponents()

    fixture = TestBed.createComponent(AdminInformationComponent)
    component = fixture.componentInstance
    component.administratorData = administratorData
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

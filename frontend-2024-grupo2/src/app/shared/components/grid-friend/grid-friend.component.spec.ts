import { ComponentFixture, TestBed } from '@angular/core/testing'
import { GridFriendComponent } from './grid-friend.component'

describe('GridFriendComponent', () => {
  let component: GridFriendComponent
  let fixture: ComponentFixture<GridFriendComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GridFriendComponent]
    }).compileComponents()

    fixture = TestBed.createComponent(GridFriendComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

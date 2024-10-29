import { ComponentFixture, TestBed } from '@angular/core/testing'

import { GridCommentComponent } from './grid-comment.component'

describe('GridCommentComponent', () => {
  let component: GridCommentComponent
  let fixture: ComponentFixture<GridCommentComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GridCommentComponent]
    })
    .compileComponents()
    
    fixture = TestBed.createComponent(GridCommentComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})

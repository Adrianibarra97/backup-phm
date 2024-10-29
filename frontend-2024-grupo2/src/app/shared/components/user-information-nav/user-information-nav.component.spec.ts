import { ComponentFixture, TestBed } from '@angular/core/testing'
import { UserInformationNavComponent } from './user-information-nav.component'
import { ActivatedRoute } from '@angular/router'

describe('UserInformationNavComponent', () => {
  let component: UserInformationNavComponent
  let fixture: ComponentFixture<UserInformationNavComponent>

  beforeEach(async () => {
    TestBed.configureTestingModule({
      declarations: [],
      imports: [UserInformationNavComponent],
      providers: [{ provide: ActivatedRoute, useValue: ActivatedRoute }]
    })
    fixture = TestBed.createComponent(UserInformationNavComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })

  it('The user clicks on profile information', () => {
    //Arrange
    const element = fixture.debugElement.nativeElement.querySelector(
      `[data-testid = "user-show"]`
    )

    //Act
    element.click()
    fixture.detectChanges()

    //Assert

    expect(element.textContent).toBe('Entradas compradas')
  })

  it('The user clicks on repeated figurines', () => {
    //Arrange
    const element = fixture.debugElement.nativeElement.querySelector(
      `[data-testid = "user-friend"]`
    )

    //Act
    element.click()
    fixture.detectChanges()

    //Assert

    expect(element.textContent).toBe('Amigos')
  })

  it('The user clicks on missing figurines', () => {
    //Arrange
    const element = fixture.debugElement.nativeElement.querySelector(
      `[data-testid = "user-comment"]`
    )

    //Act
    element.click()
    fixture.detectChanges()

    //Assert

    expect(element.textContent).toBe('Comentarios')
  })
})

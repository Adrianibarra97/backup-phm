import { NgIf } from '@angular/common'
import { Component, EventEmitter, Output } from '@angular/core'
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms'
import { ButtonModule } from 'primeng/button'
import { CheckboxModule } from 'primeng/checkbox'
import { FilterShowJSON } from 'src/app/data/models/Show'
import { AuthService } from 'src/app/data/services/auth-service/auth.service'

@Component({
  selector: 'app-search-bar',
  standalone: true,
  imports: [ButtonModule, CheckboxModule, ReactiveFormsModule, NgIf],
  templateUrl: './search-bar.component.html',
  styleUrl: './search-bar.component.css'
})
export class SearchBarComponent {
  @Output() filter: EventEmitter<FilterShowJSON> =
    new EventEmitter<FilterShowJSON>()
  public filterShow!: FormGroup
  public filterShowJSON: FilterShowJSON = {
    bandName: '',
    location: '',
    byFriends: false
  }

  constructor(
    private formBuilder: FormBuilder,
    private auth: AuthService
  ) {
    this.filterShow = this.formBuilder.group({
      bandName: '',
      location: '',
      byFriends: false
    })
  }

  isAdministrator(): boolean {
    return this.auth.isAdministrator()
  }

  isAuthorized(): boolean {
    return this.auth.isAuthorized()
  }

  onSubmit() {
    this.filterShowJSON.bandName = this.filterShow.value.bandName
    this.filterShowJSON.location = this.filterShow.value.location
    this.filterShowJSON.byFriends = this.filterShow.value.byFriends
    this.filter.emit(this.filterShowJSON)
  }
}

import { NgFor } from '@angular/common'
import { Component, EventEmitter, Input, Output } from '@angular/core'
import { AdministratorDataJSON } from 'src/app/data/models/AdministratorData'

@Component({
  selector: 'app-admin-information',
  standalone: true,
  imports: [NgFor],
  templateUrl: './admin-information.component.html',
  styleUrl: './admin-information.component.css'
})
export class AdminInformationComponent {
  @Input() administratorData!: AdministratorDataJSON
  @Output() cancelFunctionShowEvent: EventEmitter<void> =
    new EventEmitter<void>()

  cancelFunctionShow() {
    this.cancelFunctionShowEvent.emit()
  }
}

import { Component, EventEmitter, Input, Output } from '@angular/core'
import { RouterLink } from '@angular/router'
import { Show } from 'src/app/data/models/Show'
import { ShowService } from 'src/app/data/services/show-service/show.service'

@Component({
  selector: 'app-show-administrator',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './show-administrator.component.html',
  styleUrl: './show-administrator.component.css'
})
export class ShowAdministratorComponent {
  @Input() show!: Show
  @Output() update: EventEmitter<void> = new EventEmitter<void>()

  constructor(private showService: ShowService) {}

  async editShow() {
    console.log('editando show')
    this.update.emit()
  }

  async deleteShow() {
    this.showService.delete(this.show.id)
    this.update.emit()
  }
}

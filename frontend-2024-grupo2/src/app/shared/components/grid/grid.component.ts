import { Component, EventEmitter, Input, Output } from '@angular/core'
import { Show } from 'src/app/data/models/Show'
import { ShowComponent } from '../show/show.component'
import { NgIf, NgFor, NgClass } from '@angular/common'

@Component({
  selector: 'app-grid',
  standalone: true,
  imports: [ShowComponent, NgIf, NgFor, NgClass],
  templateUrl: './grid.component.html',
  styleUrl: './grid.component.css'
})
export class GridComponent {
  @Input() content: Array<Show> = []
  @Input() isAuthorized!: boolean
  @Input() isUserPage!: boolean
  @Output() update: EventEmitter<void> = new EventEmitter<void>()

  isAuthorizedByUser(item: Show): boolean {
    if (this.isUserPage) {
      return !item.userCommented
    }
    return this.isAuthorized
  }

  gridUpdate() {
    this.update.emit()
  }
}

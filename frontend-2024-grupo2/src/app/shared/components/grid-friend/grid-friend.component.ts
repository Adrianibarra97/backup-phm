import { NgClass, NgFor, NgIf } from '@angular/common'
import { Component, EventEmitter, Input, Output } from '@angular/core'
import { UserFriendJSON } from 'src/app/data/models/User'
import { UserFriendComponent } from '../user-friend/user-friend.component'

@Component({
  selector: 'app-grid-friend',
  standalone: true,
  imports: [UserFriendComponent, NgIf, NgFor, NgClass],
  templateUrl: './grid-friend.component.html',
  styleUrl: './grid-friend.component.css'
})
export class GridFriendComponent {
  @Input() content: Array<UserFriendJSON> = []
  @Output() update: EventEmitter<void> = new EventEmitter<void>()

  gridUpdate() {
    this.update.emit()
  }
}

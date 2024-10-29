import { ShowService } from 'src/app/data/services/show-service/show.service'
import { NgFor, NgIf } from '@angular/common'
import { Component, OnInit } from '@angular/core'
import { BuyTicket } from 'src/app/data/models/BuyTicket'
import { Show } from 'src/app/data/models/Show'
import { GridComponent } from 'src/app/shared/components/grid/grid.component'
import { ShowComponent } from 'src/app/shared/components/show/show.component'
import { AuthService } from 'src/app/data/services/auth-service/auth.service'

@Component({
  selector: 'app-shopping-cart',
  standalone: true,
  imports: [NgIf, NgFor, GridComponent, ShowComponent],
  templateUrl: './shopping-cart.component.html',
  styleUrl: './shopping-cart.component.css'
})
export class ShoppingCartComponent implements OnInit {
  public receivedTickets: BuyTicket[] = []
  public showsToBuy: Show[] = []
  public isUserPage: boolean = false
  public isAuthorized: boolean = false

  constructor(
    private showService: ShowService,
    private auth: AuthService
  ) {}

  getTicketsToBuy() {
    this.receivedTickets = this.showService.getTicketsToBuy()
  }

  async getShowsToBuy(): Promise<Show[]> {
    // Buscar los shows correspondientes al id de cada uno de los que están en receivedTickets
    // Ahora muestra todos los shows!
    return await this.showService.getAll()
  }

  async ngOnInit(): Promise<void> {
    this.isAuthorized = this.auth.isAuthorized()
    this.showsToBuy = await this.getShowsToBuy()
  }
}

import { NgFor, NgIf } from '@angular/common'
import { Component, Input } from '@angular/core'
import { Router, RouterLink } from '@angular/router'
import { ButtonModule } from 'primeng/button'
import { range } from 'rxjs'
import { BuyTicket } from 'src/app/data/models/BuyTicket'
import { FunctionShow } from 'src/app/data/models/FunctionShow'
import { SeatType } from 'src/app/data/models/SeatType'
import { Show } from 'src/app/data/models/Show'
import { Ticket } from 'src/app/data/models/Ticket'
import { ShowService } from 'src/app/data/services/show-service/show.service'

@Component({
  selector: 'app-tickets-consumer-information',
  standalone: true,
  imports: [NgFor, NgIf, RouterLink, ButtonModule],
  templateUrl: './tickets-consumer-information.component.html',
  styleUrl: './tickets-consumer-information.component.css'
})
export class TicketsConsumerInformationComponent {
  @Input() show!: Show
  @Input() functionShow!: FunctionShow

  public buyTicket!: BuyTicket
  public amountTicketToBuy = new Map()
  public ticketList: Ticket[] = []

  constructor(
    private showService: ShowService,
    private router: Router
  ) {}

  detectedChanges(seatTypeName: string, event: Event) {
    this.amountTicketToBuy.set(
      seatTypeName,
      (event.target as HTMLInputElement).value
    )
  }

  createTicketsToBuy() {
    this.ticketList = []
    this?.show?.placeOfShow?.ticketTypes.forEach((ticket) => {
      range(
        0,
        parseInt(this.amountTicketToBuy.get(ticket.seatType.name))
      ).forEach(() => {
        this.ticketList.push(new Ticket(ticket.seatType, ticket.price))
      })
    })
  }

  buyTickets() {
    this.createTicketsToBuy()
    this.buyTicket = new BuyTicket(
      this.show.id,
      this.functionShow.id,
      this.ticketList
    )
    this.showService.addBuyTicket(this.buyTicket)
    this.router.navigateByUrl('/shopping-cart')
  }

  functionsAreSoldOut(): boolean {
    return (
      this?.show?.functionShow.filter(
        (functionShow) => !functionShow.isSoldDout
      ).length == 0
    )
  }

  getMaxCapacity(event: SeatType): number {
    try {
      return (
        this.functionShow.availableSeatTypeList.find(
          (seatType) => seatType.name == event.name
        )?.availableCapacity || 0
      )
    } catch {
      return 0
    }
  }
}

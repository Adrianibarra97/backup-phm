import { Ticket, TicketJSON } from './Ticket'

export type BuyTicketJSON = {
  showId: string
  functionShowId: string
  ticketList: TicketJSON[]
}

export class BuyTicket {
  constructor(
    public showId: number,
    public functionShowId: number,
    public ticketList: Ticket[]
  ) {}

  static fromJSON(buyTicketJSON: BuyTicketJSON): BuyTicket {
    return Object.assign(
      new BuyTicket(
        parseInt(buyTicketJSON.showId),
        parseInt(buyTicketJSON.functionShowId),
        buyTicketJSON.ticketList.map((ticketJSON) =>
          Ticket.fromJSON(ticketJSON)
        )
      )
    )
  }

  toJSON(): BuyTicketJSON {
    return {
      showId: this.showId.toString(),
      functionShowId: this.functionShowId.toString(),
      ticketList: this.ticketList.map((ticket) => ticket.toJSON())
    }
  }
}

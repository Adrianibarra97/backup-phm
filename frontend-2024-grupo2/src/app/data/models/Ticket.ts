import { SeatType, SeatTypeJSON } from "./SeatType"

export type TicketJSON = {
	seatType: SeatTypeJSON
	price: number
}

export class Ticket {
  
	constructor(
		public seatType: SeatType,
		public price: number
	) {}

	static fromJSON(ticketJSON: TicketJSON): Ticket {
		return Object.assign(new Ticket(
			SeatType.fromJSON(ticketJSON.seatType),
			ticketJSON.price
		))
	}

	toJSON(): TicketJSON {
		return {
			seatType: this.seatType.toJSON(),
			price: this.price
		}
	}
}
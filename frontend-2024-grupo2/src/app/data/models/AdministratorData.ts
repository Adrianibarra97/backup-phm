import { SeatType, SeatTypeJSON } from './SeatType'

export type AdministratorDataJSON = {
  totalAmountOfTickets: number
  amountOfTicketPerSeatType: SeatTypeJSON[]
  totalSales: number
  totalCost: number
  amountPeopleWaiting: number
  profit: number
  amountFunctionsSoldOut: number
}

export class AdministratorData {
  constructor(
    public totalAmountOfTickets: number,
    public amountOfTicketPerSeatType: SeatType[],
    public totalSales: number,
    public totalCost: number,
    public amountPeopleWaiting: number,
    public profit: number,
    public amountFunctionsSoldOut: number
  ) {}

  static fromJSON(
    administratorDataJSON: AdministratorDataJSON
  ): AdministratorData {
    return Object.assign(
      new AdministratorData(
        administratorDataJSON.totalAmountOfTickets,
        administratorDataJSON.amountOfTicketPerSeatType.map((seatType) =>
          SeatType.fromJSON(seatType)
        ),
        administratorDataJSON.totalSales,
        administratorDataJSON.totalCost,
        administratorDataJSON.amountPeopleWaiting,
        administratorDataJSON.profit,
        administratorDataJSON.amountFunctionsSoldOut
      )
    )
  }

  toJSON(): AdministratorDataJSON {
    return {
      totalAmountOfTickets: this.totalAmountOfTickets,
      amountOfTicketPerSeatType: this.amountOfTicketPerSeatType.map(
        (seatType) => seatType.toJSON()
      ),
      totalSales: this.totalSales,
      totalCost: this.totalCost,
      amountPeopleWaiting: this.amountPeopleWaiting,
      profit: this.profit,
      amountFunctionsSoldOut: this.amountFunctionsSoldOut
    }
  }
}

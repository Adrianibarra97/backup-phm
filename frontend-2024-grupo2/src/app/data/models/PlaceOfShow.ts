import { LocationPlace, LocationPlaceJSON } from './LocationPlace'
import { Ticket, TicketJSON } from './Ticket'

export type PlaceOfShowJSON = {
  name: string
  mapLocation: LocationPlaceJSON
  fixedCost: number
  type: string
  ticketTypes: Array<TicketJSON>
}

export class PlaceOfShow {
  constructor(
    public name: string,
    public mapLocation: LocationPlace,
    public fixedCost: number,
    public type: string,
    public ticketTypes: Array<Ticket>
  ) {}

  static fromJSON(placeOfShowJSON: PlaceOfShowJSON): PlaceOfShow {
    return Object.assign(
      new PlaceOfShow(
        placeOfShowJSON.name,
        LocationPlace.fromJSON(placeOfShowJSON.mapLocation),
        placeOfShowJSON.fixedCost,
        placeOfShowJSON.type,
        placeOfShowJSON.ticketTypes.map(ticketType => Ticket.fromJSON(ticketType))
      )
    )
  }

  toJSON(): PlaceOfShowJSON {
    return {
      name: this.name,
      mapLocation: this.mapLocation.toJSON(),
      fixedCost: this.fixedCost,
      type: this.type,
      ticketTypes: this.ticketTypes.map(ticketType => ticketType.toJSON())
    }
  }
}

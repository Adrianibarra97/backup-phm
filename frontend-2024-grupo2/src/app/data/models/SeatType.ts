
export type SeatTypeJSON = {
  name: string
  availableCapacity:number
}

export class SeatType {

	constructor(
		public name: string,
		public availableCapacity: number
	) {}

	static fromJSON(seatTypeJSON: SeatTypeJSON): SeatType {
		return Object.assign(new SeatType(
			seatTypeJSON.name,
			seatTypeJSON.availableCapacity
		))
	}

	toJSON(): SeatTypeJSON {
		return {
			name: this.name,
			availableCapacity: this.availableCapacity
		}
	}
}
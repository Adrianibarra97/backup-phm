import { SeatType, SeatTypeJSON } from './SeatType'

export type FunctionShowJSON = {
  id: number
  dayOfFunction: string
  hourOfFunction: string
  isSoldDout: boolean
  availableSeatTypeList: SeatTypeJSON[]
}

export class FunctionShow {
  constructor(
    public id: number,
    public dayOfFunction: string,
    public hourOfFunction: Date,
    public isSoldDout: boolean,
    public availableSeatTypeList: SeatType[]
  ) {}

  static fromJSON(functionShow: FunctionShowJSON): FunctionShow {
    return Object.assign(
      new FunctionShow(
        functionShow.id,
        functionShow.dayOfFunction,
        new Date(functionShow.hourOfFunction),
        functionShow.isSoldDout,
        functionShow.availableSeatTypeList.map((seatType) =>
          SeatType.fromJSON(seatType)
        )
      )
    )
  }

  toJSON(): FunctionShowJSON {
    const newDateToFunction: string =
      this.hourOfFunction.getUTCFullYear() +
      '-' +
      (this.hourOfFunction.getMonth() + 1) +
      '-' +
      this.hourOfFunction.getDate() +
      '-' +
      this.hourOfFunction.getHours() +
      '-' +
      this.hourOfFunction.getMinutes() +
      '-' +
      this.hourOfFunction.getSeconds()
    return {
      id: this.id,
      dayOfFunction: this.dayOfFunction,
      hourOfFunction: newDateToFunction,
      isSoldDout: this.isSoldDout,
      availableSeatTypeList: this.availableSeatTypeList
    }
  }
}

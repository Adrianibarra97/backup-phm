export type StatusShowJSON = {
  name: string
  profitStatusShowType: number
}

export class StatusShow {
  constructor(
    public name: string,
    public profitStatusShowType: number
  ) {}

  static fromJSON(statusShowJSON: StatusShowJSON): StatusShow {
    return Object.assign(
      new StatusShow(statusShowJSON.name, statusShowJSON.profitStatusShowType)
    )
  }

  toJSON(): StatusShowJSON {
    return {
      name: this.name,
      profitStatusShowType: this.profitStatusShowType
    }
  }
}

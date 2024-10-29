import { PlaceOfShow, PlaceOfShowJSON } from './PlaceOfShow'
import { StatusShow, StatusShowJSON } from './StatusShow'
import { FunctionShow, FunctionShowJSON } from './FunctionShow'
import { UserFriendJSON } from './User'

export type ShowJSON = {
  id: number
  bandName: string
  placeOfShow: PlaceOfShowJSON
  nameOfRecital: string
  img: string
  status: StatusShowJSON
  costBand: number
  functionShow: FunctionShowJSON[]
  friendWithShow: UserFriendJSON[]
  score: number
  amountOfComments: number
  maxPrice: number
  minPrice: number
  userCommented: boolean
  ticketPriceForUser: number
}

export type FilterShowJSON = {
  bandName: string
  location: string
  byFriends: boolean
}

export class Show {
  constructor(
    public id: number,
    public bandName: string,
    public placeOfShow: PlaceOfShow,
    public nameOfRecital: string,
    public img: string,
    public status: StatusShow,
    public costBand: number,
    public functionShow: FunctionShow[],
    public friends: UserFriendJSON[],
    public score: number,
    public amountOfComments: number,
    public maxPrice: number,
    public minPrice: number,
    public userCommented: boolean,
    public ticketPriceForUser: number
  ) {}

  static fromJSON(showJSON: ShowJSON): Show {
    return Object.assign(
      new Show(
        showJSON.id,
        showJSON.bandName,
        PlaceOfShow.fromJSON(showJSON.placeOfShow),
        showJSON.nameOfRecital,
        showJSON.img,
        StatusShow.fromJSON(showJSON.status),
        showJSON.costBand,
        showJSON.functionShow.map((functionJSON) =>
          FunctionShow.fromJSON(functionJSON)
        ),
        showJSON.friendWithShow,
        showJSON.score,
        showJSON.amountOfComments,
        showJSON.maxPrice,
        showJSON.minPrice,
        showJSON.userCommented,
        showJSON.ticketPriceForUser
      )
    )
  }

  toJSON(): ShowJSON {
    return {
      id: this.id,
      bandName: this.bandName,
      placeOfShow: this.placeOfShow.toJSON(),
      nameOfRecital: this.nameOfRecital,
      img: this.img,
      status: this.status.toJSON(),
      costBand: this.costBand,
      functionShow: this.functionShow.map((functionShow) =>
        functionShow.toJSON()
      ),
      friendWithShow: this.friends,
      score: this.score,
      amountOfComments: this.amountOfComments,
      maxPrice: this.maxPrice,
      minPrice: this.minPrice,
      userCommented: this.userCommented,
      ticketPriceForUser: this.ticketPriceForUser
    }
  }
}

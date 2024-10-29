import { Role, RoleJSON } from './Role'

export type UserJSON = {
  name: string
  surname: string
  username: string
  imageURL: string
  country: string
  birthOfDate: string
  dni: number
  password: number
  availableMoney: number
  role: RoleJSON
}

export type UserFriendJSON = {
  id: number
  name: string
  country: string
  image: string
}

export type UserLoggedJSON = {
  id: number
  name: string
  surname: string
  image: string
  role: RoleJSON
}

export type UserLoginJSON = {
  username: string
  password: number
}

export class User {
  constructor(
    public name: string,
    public surname: string,
    public username: string,
    public imageURL: string,
    public country: string,
    public birthOfDate: Date,
    public dni: number,
    public availableMoney: number,
    public role: Role
  ) {}

  static fromJSON(userJSON: UserJSON): User {
    return Object.assign(
      new User(
        userJSON.name,
        userJSON.surname,
        userJSON.username,
        userJSON.imageURL,
        userJSON.country,
        new Date(userJSON.birthOfDate),
        userJSON.dni,
        userJSON.availableMoney,
        Role.fromJSON(userJSON.role)
      )
    )
  }

  toJSON(): UserJSON {
    const birthOfDate: string =
      '' +
      this.birthOfDate.getFullYear() +
      '-' +
      (this.birthOfDate.getMonth() + 1) +
      '-' +
      this.birthOfDate.getDate()
    return {
      name: this.name,
      surname: this.surname,
      username: this.username,
      imageURL: this.imageURL,
      country: this.country,
      birthOfDate: birthOfDate,
      dni: this.dni,
      password: 0,
      availableMoney: this.availableMoney,
      role: this.role.toJSON()
    }
  }
}


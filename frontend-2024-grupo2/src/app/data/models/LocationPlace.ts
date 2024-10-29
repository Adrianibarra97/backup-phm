export type LocationPlaceJSON = {
  longitud: number
  latitud: number
}

export class LocationPlace {
  constructor(
    public longitud: number,
    public latitud: number
  ) {}

  static fromJSON(locationPlaceJSON: LocationPlaceJSON): LocationPlace {
    return Object.assign(
      new LocationPlace(locationPlaceJSON.longitud, locationPlaceJSON.latitud)
    )
  }

  toJSON(): LocationPlaceJSON {
    return {
      longitud: this.longitud,
      latitud: this.latitud
    }
  }
}

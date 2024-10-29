import { Injectable } from '@angular/core'
import { BaseService } from '../BaseService'
import { FilterShowJSON, Show, ShowJSON } from '../../models/Show'
import { HttpClient } from '@angular/common/http'
import { AuthService } from '../auth-service/auth.service'
import { REST_SERVER_URL } from '../Configuration'
import { lastValueFrom } from 'rxjs'
import { CommentJSON } from '../../models/Comment'
import { ErrorHandler } from 'src/app/util/ErrorHandler'
import { BuyTicket } from '../../models/BuyTicket'
import { AdministratorData } from '../../models/AdministratorData'
import { FunctionShow } from '../../models/FunctionShow'
import { PlaceOfShow, PlaceOfShowJSON } from '../../models/PlaceOfShow'

@Injectable({
  providedIn: 'root'
})
export class ShowService implements BaseService<Show> {
  public buyTickets: BuyTicket[] = []

  constructor(
    private http: HttpClient,
    private auth: AuthService,
    private httpErrorHandler: ErrorHandler
  ) {}

  addBuyTicket(buyTicket: BuyTicket) {
    this.buyTickets.push(buyTicket)
  }

  getTicketsToBuy(): BuyTicket[] {
    return this.buyTickets
  }

  async getAll(): Promise<Show[]> {
    try {
      const showsJSON$ = this.http.get<ShowJSON[]>(
        REST_SERVER_URL + '/shows/all/' + (await this.auth.getUserActiveId())
      )
      const shows = await lastValueFrom(showsJSON$)
      return shows.map((ShowJSON) => Show.fromJSON(ShowJSON))
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async getAllPlacesOfShow(): Promise<PlaceOfShow[]> {
    try {
      const placesOfShowJSON$ = this.http.get<PlaceOfShowJSON[]>(
        REST_SERVER_URL + '/shows/places-of-shows'
      )
      const placesOfShow = await lastValueFrom(placesOfShowJSON$)
      return placesOfShow.map((placeOfShowJSON) =>
        PlaceOfShow.fromJSON(placeOfShowJSON)
      )
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async getOneById(id: number): Promise<Show> {
    try {
      const showsJSON$ = this.http.get<ShowJSON>(
        REST_SERVER_URL + '/shows/' + id
      )
      const show = await lastValueFrom(showsJSON$)
      return Show.fromJSON(show)
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async getShowsFilterBy(filterShowJSON: FilterShowJSON): Promise<Show[]> {
    try {
      const urlParameters: string =
        '/shows/filter-by/' + (await this.auth.getUserActiveId())
      const showsJSON$ = this.http.post<ShowJSON[]>(
        REST_SERVER_URL + urlParameters,
        filterShowJSON
      )
      const shows = await lastValueFrom(showsJSON$)
      return shows.map((showJSON) => Show.fromJSON(showJSON))
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async getCommentsByShow(id: number): Promise<CommentJSON[]> {
    try {
      const urlParameters: string = '/shows/comments/' + id
      const showsCommentJSON$ = this.http.get<CommentJSON[]>(
        REST_SERVER_URL + urlParameters
      )
      return await lastValueFrom(showsCommentJSON$)
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async getAdministratorData(id: number): Promise<AdministratorData> {
    try {
      const urlParameters: string = '/shows/administrator-data/' + id
      const dataAdministratorJSON$ = this.http.get<AdministratorData>(
        REST_SERVER_URL + urlParameters
      )
      return await lastValueFrom(dataAdministratorJSON$)
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async create(object: Show): Promise<void> {
    try {
      const showCreated$ = this.http.post<void>(
        REST_SERVER_URL + '/shows/create-show',
        object.toJSON()
      )
      return await lastValueFrom(showCreated$)
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async createFunctionShow(showId: number, functionShow: FunctionShow) {
    try {
      const functionShowCreated$ = this.http.post<void>(
        REST_SERVER_URL + '/shows/create-function/' + showId,
        functionShow.toJSON()
      )
      return await lastValueFrom(functionShowCreated$)
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async update(object: Show): Promise<void> {
    try {
      const showUpdated$ = this.http.put<void>(
        REST_SERVER_URL +
          '/shows/update-show/' +
          (await this.auth.getUserActiveId()),
        object.toJSON()
      )
      return await lastValueFrom(showUpdated$)
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async delete(id: number): Promise<void> {
    try {
      const showDelete$ = this.http.delete<void>(
        REST_SERVER_URL + '/shows/delete-shows/' + id
      )
      return await lastValueFrom(showDelete$)
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }
}

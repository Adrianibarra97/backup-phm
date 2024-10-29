import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core'
import { BaseService } from '../BaseService'
import { User, UserFriendJSON, UserJSON } from '../../models/User'
import { REST_SERVER_URL } from '../Configuration'
import { lastValueFrom } from 'rxjs'
import { AuthService } from '../auth-service/auth.service'
import { CommentJSON } from '../../models/Comment'
import { Show, ShowJSON } from '../../models/Show'
import { ErrorHandler } from 'src/app/util/ErrorHandler'

@Injectable({
  providedIn: 'root'
})
export class UserService implements BaseService<User> {
  constructor(
    private http: HttpClient,
    private auth: AuthService,
    private httpErrorHandler: ErrorHandler
  ) {}

  async getAll(): Promise<User[]> {
    try {
      const usersJSON$ = this.http.get<UserJSON[]>(
        REST_SERVER_URL + '/user/all'
      )
      const users = await lastValueFrom(usersJSON$)
      return users.map((userJSON) => User.fromJSON(userJSON))
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async getOneById(id: number): Promise<User> {
    try {
      const userJSON$ = this.http.get<UserJSON>(REST_SERVER_URL + '/user/' + id)
      const user = await lastValueFrom(userJSON$)
      return User.fromJSON(user)
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async addCreditToUser(): Promise<void> {
    try {
      const addCredit$ = this.http.get<void>(
        REST_SERVER_URL +
          '/user/add-credit/' +
          (await this.auth.getUserActiveId())
      )
      return await lastValueFrom(addCredit$)
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async getComments(): Promise<CommentJSON[]> {
    try {
      const commentsJSON$ = this.http.get<CommentJSON[]>(
        REST_SERVER_URL + '/user/comment/' + (await this.auth.getUserActiveId())
      )
      return await lastValueFrom(commentsJSON$)
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async getFriend(): Promise<UserFriendJSON[]> {
    try {
      const userFriendsJSON$ = this.http.get<UserFriendJSON[]>(
        REST_SERVER_URL + '/user/friend/' + (await this.auth.getUserActiveId())
      )
      return await lastValueFrom(userFriendsJSON$)
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async getShows(): Promise<Show[]> {
    try {
      const showJSON$ = this.http.get<ShowJSON[]>(
        REST_SERVER_URL + '/user/show/' + (await this.auth.getUserActiveId())
      )
      const shows = await lastValueFrom(showJSON$)
      return shows.map((showJSON) => Show.fromJSON(showJSON))
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async create(object: User): Promise<void> {
    try {
      const userCreated$ = this.http.post<void>(
        REST_SERVER_URL + '/user/create-user',
        object.toJSON()
      )
      return await lastValueFrom(userCreated$)
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async createCommentToUser(commentJSON: CommentJSON): Promise<void> {
    try {
      const urlParams: string =
        '/user/create-comment/' +
        commentJSON.id +
        '/' +
        (await this.auth.getUserActiveId())
      const commentCreated$ = this.http.post<void>(
        REST_SERVER_URL + urlParams,
        commentJSON
      )
      return lastValueFrom(commentCreated$)
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async update(object: User): Promise<void> {
    try {
      const userUpdated$ = this.http.put<void>(
        REST_SERVER_URL +
          '/user/update-user/' +
          (await this.auth.getUserActiveId()),
        object.toJSON()
      )
      return await lastValueFrom(userUpdated$)
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async delete(id: number): Promise<void> {
    try {
      const userDelete$ = this.http.delete<void>(
        REST_SERVER_URL + '/user/delete-user/' + id
      )
      return await lastValueFrom(userDelete$)
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async deleteFriend(id: number): Promise<void> {
    try {
      const friendToDelete$ = this.http.delete<void>(
        REST_SERVER_URL +
          '/user/remove-friend/' +
          id +
          '/' +
          (await this.auth.getUserActiveId())
      )
      return await lastValueFrom(friendToDelete$)
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }

  async deleteComment(id: number): Promise<void> {
    try {
      const commentToDelete$ = this.http.delete<void>(
        REST_SERVER_URL +
          '/user/delete-comment/' +
          id +
          '/' +
          (await this.auth.getUserActiveId())
      )
      return await lastValueFrom(commentToDelete$)
    } catch (error) {
      this.httpErrorHandler.errorHandler(error)
      throw Error('Falla inesperada!')
    }
  }
}

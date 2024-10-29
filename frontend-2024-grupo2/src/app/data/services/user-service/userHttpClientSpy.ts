import { of } from 'rxjs'
import { REST_SERVER_URL } from '../Configuration'
import { UserJSON } from '../../models/User'

const userStubList: UserJSON[] = [
  {
    name: 'Joaquin',
    surname: 'Lopez',
    username: 'Joaco3312',
    imageURL: 'https://image.com/joaco.png',
    country: 'Perú',
    birthOfDate: '1997-5-24',
    dni: 2345676,
    password: 0,
    availableMoney: 1000.1,
    role: {
      name: 'Consumer',
      isAdministrator: false
    }
  },
  {
    name: 'Ana',
    surname: 'Perez',
    username: 'Ani234',
    imageURL: 'https://image.com/anita.png',
    country: 'Perú',
    birthOfDate: '1997-4-24',
    dni: 23456762,
    password: 0,
    availableMoney: 2100.1,
    role: {
      name: 'Consumer',
      isAdministrator: false
    }
  },
  {
    name: 'Adrian',
    surname: 'Ibarra',
    username: 'adri9730',
    imageURL: 'https://image.com/adrian.png',
    country: 'Argentina',
    birthOfDate: '1997-3-30',
    dni: 40218352,
    password: 0,
    availableMoney: 1200.1,
    role: {
      name: 'Consumer',
      isAdministrator: false
    }
  }
]

export const userHttpClientSpy = jasmine.createSpyObj('HttpClient', [
  'get',
  'put',
  'post'
])

userHttpClientSpy.get
  .withArgs(`${REST_SERVER_URL}/usuarios`)
  .and.returnValue(of(userStubList))

userHttpClientSpy.get
  .withArgs(`${REST_SERVER_URL}/usuarios/2`)
  .and.returnValue(of(userStubList[2]))

userHttpClientSpy.get
  .withArgs(`${REST_SERVER_URL}/usuarios/0`)
  .and.returnValue(of(userStubList[0]))

userHttpClientSpy.put.and.returnValue(of())

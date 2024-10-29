export abstract class CustomError extends Error {
  abstract statusCode: number

  constructor(message: string) {
    super(message)
    Object.setPrototypeOf(this, new.target.prototype)
  }
}

export class NotConectionError extends CustomError {
  statusCode = 0
  constructor(message: string) {
    super(message)
    this.name = 'NotConectionError'
  }
}

export class ValidationError extends CustomError {
  statusCode = 400
  constructor(message: string) {
    super(message)
    this.name = 'ValidationError'
  }
}

export class UnauthorizedError extends CustomError {
  statusCode = 401
  constructor(message: string) {
    super(message)
    this.name = 'UnauthorizedError'
  }
}

export class NotFoundError extends CustomError {
  statusCode = 404
  constructor(message: string) {
    super(message)
    this.name = 'NotFoundError'
  }
}

export class ServerError extends CustomError {
  statusCode = 500
  constructor(message: string) {
    super(message)
    this.name = 'ServerError'
  }
}

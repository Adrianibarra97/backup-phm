package ar.edu.unsam.phm.backendgrupo2.domain

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class EmptyArgumentException(message: String): RuntimeException(message) {}

@ResponseStatus(HttpStatus.BAD_REQUEST)
class IncorrectArgumentException(message: String): RuntimeException(message) {}

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException(message: String): RuntimeException(message) {}

@ResponseStatus(HttpStatus.UNAUTHORIZED)
class UnauthorizedException(message: String): RuntimeException(message) {}
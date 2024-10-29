package ar.edu.unsam.phm.backendgrupo2.util

import ar.edu.unsam.phm.backendgrupo2.domain.*

object DataValidator {

  fun incorrectPassword(realPassword: Int, possiblePassword: Int) {
    if (realPassword != possiblePassword)
      throw IncorrectArgumentException("Usuario o contraseña incorrectos")
  }
  
  fun stringsPartiallyMatch(stringToValidate: String, listStringsToCompare: List<String>) {
    if (!listStringsToCompare.any { it.contains(stringToValidate) })
      throw IncorrectArgumentException("No se encontro coincidencia parcial entre los valores!")
  }

  fun stringsPerfectlyMatch(stringToValidate: String, listStringsToCompare: List<String>) {
    if(!listStringsToCompare.any { it == stringToValidate })
      throw IncorrectArgumentException("No se encontro coincidencia exacta entre los valores!")
  }

  fun someStringIsEmpty(listStringsToCompare: List<String?>) {
    if (listStringsToCompare.any { it!!.isEmpty() })
      throw EmptyArgumentException("Los datos no pueden contener valores nulos!")
  }

  fun stringIsValidToDate(dateToValidate: String) {
    val dateList: List<String> = dateToValidate.split("-")
    this.stringValidToInt(dateList)
    this.someStringIsEmpty(dateList)
  }

  fun userIsAdministrator(user: User) {
    if(!user.role?.isAdministrator!!)
      throw UnauthorizedException("No posee los permisos necesarios para realizar esta acción")
  }

  fun isValidIndex(index: Int, listSize: Int) {
    if (index !in 0..<listSize)
      throw NotFoundException("El id no es válido!")
  }

  private fun stringValidToInt(dateList: List<String>) {
    try {
      dateList.forEach{ it.toInt() }
    } catch (e: Exception) {
      throw IncorrectArgumentException("El formato recibido no corresponde a una fecha. Debería ser AAAA-MM-DD!")
    }
  }
}
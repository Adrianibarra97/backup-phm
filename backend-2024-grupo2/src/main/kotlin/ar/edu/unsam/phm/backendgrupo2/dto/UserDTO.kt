package ar.edu.unsam.phm.backendgrupo2.dto

import ar.edu.unsam.phm.backendgrupo2.domain.User

data class UserDTO(val user: User) {
  val id: Int = user.id
  val name: String = user.name
  val surname: String = user.surname
  val username: String = user.username
  val imageURL: String = user.imageUrl
  val country: String = user.country
  val birthOfDate: String = user.birthOfDate.toString()
  val dni: Int = user.dni
  var password: Int = 0
  var availableMoney: Double = user.availableMoney.toDouble()
  val role: RoleDTO = RoleDTO(user.role!!)
}

data class UserFriendDTO(var user: User) {
  val id: Int = user.id
  val name: String = user.name
  val country: String = user.country
  val image: String = user.imageUrl
}

data class UserLoggedDTO(var user: User) {
  val id: Int = user.id
  val name: String = user.name
  val surname: String = user.surname
  val image: String = user.imageUrl
  val role: RoleDTO = RoleDTO(user.role!!)
}

data class UserLoginDTO(
  val username: String,
  val password: Int
)
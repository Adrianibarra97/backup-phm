package ar.edu.unsam.phm.backendgrupo2.dto

import ar.edu.unsam.phm.backendgrupo2.domain.Role

data class RoleDTO(val role: Role) {
  val id: Int = role.id
  val name: String = role.name
  val isAdministrator: Boolean = role.isAdministrator
}
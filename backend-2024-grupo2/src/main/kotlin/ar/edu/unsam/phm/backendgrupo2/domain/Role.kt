package ar.edu.unsam.phm.backendgrupo2.domain

import ar.edu.unsam.phm.backendgrupo2.dto.RoleDTO
import jakarta.persistence.*

@Entity
@Table(name = "role")
class Role {

  companion object {

    fun fromJSON(roleDTO: RoleDTO): Role =
      Role().apply {
        this.id = roleDTO.id
        this.name = roleDTO.name
        this.isAdministrator = roleDTO.isAdministrator
      }
  }

  @Id
  @GeneratedValue
  var id: Int = 0

  @Column(length = 40)
  var name: String = ""

  @Column
  var isAdministrator: Boolean = false
}
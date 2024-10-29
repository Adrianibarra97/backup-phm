package ar.edu.unsam.phm.backendgrupo2.domain

import ar.edu.unsam.phm.backendgrupo2.dto.LocationDTO
import jakarta.persistence.*

@Entity
@Table(name = "location")
class Location {

  companion object {
    fun fromJSON(locationDTO: LocationDTO): Location =
      Location().apply {
        this.id = locationDTO.id
        this.latitud = locationDTO.latitude
        this.longitud = locationDTO.longitude
      }
  }

  @Id
  @GeneratedValue
  var id: Int = 0

  @Column
  var longitud: Double = 0.0

  @Column
  var latitud: Double = 0.0
}
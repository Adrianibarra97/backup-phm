package ar.edu.unsam.phm.backendgrupo2.dto

import ar.edu.unsam.phm.backendgrupo2.domain.Location

data class LocationDTO(val location: Location) {
  val id: Int = location.id
  val longitude: Double = location.longitud
  val latitude: Double = location.latitud
}
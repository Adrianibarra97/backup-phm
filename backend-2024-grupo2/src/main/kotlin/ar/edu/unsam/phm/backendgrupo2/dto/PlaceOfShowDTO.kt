package ar.edu.unsam.phm.backendgrupo2.dto

import ar.edu.unsam.phm.backendgrupo2.domain.PlaceOfShow

data class PlaceOfShowDTO(val placeOfShow: PlaceOfShow) {
  val id: Int = placeOfShow.id
  val name: String = placeOfShow.name
  val mapLocation: LocationDTO = LocationDTO(placeOfShow.mapLocation!!)
  var fixedCost: Double = placeOfShow.fixedCost.toDouble()
  val type: String = placeOfShow.type
  val hasGoodAcoustic: Boolean = placeOfShow.hasGoodAcoustic
  val ticketTypes: List<TicketDTO> = placeOfShow.ticketsTypeList.map { TicketDTO(it) }
}
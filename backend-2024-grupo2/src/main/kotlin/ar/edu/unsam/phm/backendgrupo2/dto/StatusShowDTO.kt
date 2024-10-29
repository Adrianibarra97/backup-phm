package ar.edu.unsam.phm.backendgrupo2.dto

import ar.edu.unsam.phm.backendgrupo2.domain.StatusShow

data class StatusShowDTO(val statusShow: StatusShow) {
  val id: Int = statusShow.id
  val name: String = statusShow.name
  val profitStatusShowType: Double = statusShow.profitStatusShowType.toDouble()
}
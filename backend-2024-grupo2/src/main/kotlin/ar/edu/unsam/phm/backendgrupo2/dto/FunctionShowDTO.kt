package ar.edu.unsam.phm.backendgrupo2.dto

import ar.edu.unsam.phm.backendgrupo2.domain.FunctionShow
import ar.edu.unsam.phm.backendgrupo2.domain.SeatType

data class FunctionShowDTO(val functionShow: FunctionShow) {
  val id: Int = functionShow.id
  val hourOfFunction: String = functionShow.hourOfFunction.toString()
  val isSoldOut: Boolean = functionShow.isSoldOut()
  val availableSeatTypeList: List<SeatTypeDTO> = functionShow.show?.placeOfShow!!.ticketsTypeList.map {
    SeatTypeDTO(SeatType(), functionShow)
  }
}
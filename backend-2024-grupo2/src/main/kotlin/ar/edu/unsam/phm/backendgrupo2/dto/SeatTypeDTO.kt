package ar.edu.unsam.phm.backendgrupo2.dto

import ar.edu.unsam.phm.backendgrupo2.domain.FunctionShow
import ar.edu.unsam.phm.backendgrupo2.domain.SeatType

data class SeatTypeDTO(var seatType: SeatType, var functionShow: FunctionShow) {
  val id: Int = seatType.id
  val name: String = seatType.name
  val availableCapacity: Int = functionShow.availablePerSeatType(seatType)
  val costSeatType: Double = seatType.costSeatType.toDouble()
}
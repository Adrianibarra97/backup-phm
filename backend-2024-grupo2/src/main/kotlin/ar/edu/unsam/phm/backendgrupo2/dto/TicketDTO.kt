package ar.edu.unsam.phm.backendgrupo2.dto

import ar.edu.unsam.phm.backendgrupo2.domain.Ticket

data class TicketDTO(val ticket: Ticket) {
  val id: Int = ticket.id
  val seatType: SeatTypeDTO = SeatTypeDTO(ticket.seatType!!, ticket.functionShow!!)
  val price: Double = ticket.price().toDouble()
}
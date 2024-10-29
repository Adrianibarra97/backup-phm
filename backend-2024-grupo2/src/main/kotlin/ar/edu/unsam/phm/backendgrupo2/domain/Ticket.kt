package ar.edu.unsam.phm.backendgrupo2.domain

import ar.edu.unsam.phm.backendgrupo2.dto.TicketDTO
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "ticket")
class Ticket {

  companion object {
    fun fromJSON(ticketDTO: TicketDTO, functionShow: FunctionShow): Ticket =
      Ticket().apply {
        this.id = ticketDTO.id
        this.seatType = SeatType.fromJSON(ticketDTO.seatType)
        this.functionShow = functionShow
      }
  }

  @Id
  @GeneratedValue
  var id: Int = 0

  @ManyToOne(fetch = FetchType.EAGER)
  var seatType: SeatType? = null

  @ManyToOne(fetch = FetchType.EAGER)
  var functionShow: FunctionShow? = null
  
  fun cost(): BigDecimal {
    val placeOfShow: PlaceOfShow = this.functionShow?.show?.placeOfShow!!
    return if (placeOfShow.amountOfPlaces() != 0)
      (placeOfShow.locationCost(this) + this.functionShow?.show?.costBand!!) /
        (placeOfShow.amountOfPlaces().toBigDecimal())
    else 0.0.toBigDecimal()
  }

  fun price(): BigDecimal =
    this.cost() * this.functionShow?.show!!.status?.profit()!!
  
  fun hasComment(comment: Comment): Boolean =
    this.functionShow?.show?.hasComment(comment)!!
}
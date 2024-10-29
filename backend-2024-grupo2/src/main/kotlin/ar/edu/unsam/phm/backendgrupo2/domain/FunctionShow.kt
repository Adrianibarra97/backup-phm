package ar.edu.unsam.phm.backendgrupo2.domain

import ar.edu.unsam.phm.backendgrupo2.dto.FunctionShowDTO
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "function_show")
class FunctionShow {
  
  companion object {
    fun fromJSON(functionShowDTO: FunctionShowDTO): FunctionShow {
      val listDate = functionShowDTO.hourOfFunction.split("-")
      val newHourOfFunction: LocalDateTime = LocalDateTime.of(
        listDate[0].toInt(),
        listDate[1].toInt(),
        listDate[2].toInt(),
        listDate[3].toInt(),
        listDate[4].toInt(),
        listDate[5].toInt()
      )
      return FunctionShow().apply {
        this.id = functionShowDTO.id
        this.hourOfFunction = newHourOfFunction
      }
    }
  }

  @Id
  @GeneratedValue
  var id: Int = 0

  @Column
  var hourOfFunction: LocalDateTime? = null
  
  @ManyToOne
  var show: Show? = null

  @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
  val ticketList: MutableList<Ticket> = mutableListOf()

  fun isSoldOut(): Boolean =
    this.show?.placeOfShow?.amountOfPlaces()!! - this.ticketList.size == 0

  fun addTicket(ticket: Ticket) =
    this.ticketList.add(ticket)

  fun addTicketsToFunction(ticket: List<Ticket>) =
    this.ticketList.addAll(ticket)

  fun minTicketPrice(): BigDecimal =
    if(this.ticketList.isEmpty()) 0.toBigDecimal()
    else this.ticketList.minOf { it.price() }

  fun maxTicketPrice(): BigDecimal =
    if(this.ticketList.isEmpty()) 0.toBigDecimal()
    else this.ticketList.maxOf { it.price() }

  fun totalSales(): BigDecimal =
    if(this.ticketList.isEmpty()) 0.toBigDecimal()
    else this.ticketList.sumOf { it.price() }

  fun amountOfTicketsSold(): Int =
    this.ticketList.size
  
  fun availableSeatTypes(): List<SeatType> =
    this.show?.placeOfShow!!.ticketsTypeList.map {
      SeatType().apply {
        this.name = it.seatType!!.name
        this.capacity = this@FunctionShow.availablePerSeatType(it.seatType!!)
        this.costSeatType = 0.0.toBigDecimal()
      }
    }
  
  fun ticketsBySeatType(seatType: SeatType): Int =
    this.ticketList.filter { it.seatType?.name === seatType.name }.size
  
  fun availablePerSeatType(seatType: SeatType): Int {
    return this.show?.placeOfShow!!.amountSeatsPerType(seatType) - this.ticketsBySeatType(seatType)
  }
}
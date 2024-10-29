package ar.edu.unsam.phm.backendgrupo2.domain

import ar.edu.unsam.phm.backendgrupo2.dto.SeatTypeDTO
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "seat_type")
class SeatType {
  
  companion object {
    fun fromJSON(seatTypeDTO: SeatTypeDTO): SeatType =
      SeatType().apply {
        this.id = seatTypeDTO.id
        this.name = seatTypeDTO.name
        this.costSeatType = seatTypeDTO.costSeatType.toBigDecimal()
        this.capacity = seatTypeDTO.availableCapacity
      }
  }
  
  @Id
  @GeneratedValue
  var id: Int = 0
  
  @Column(length = 40)
  var name: String = ""
  
  @Column
  var capacity: Int = 0
  
  @Column
  var costSeatType: BigDecimal = 0.toBigDecimal()
}
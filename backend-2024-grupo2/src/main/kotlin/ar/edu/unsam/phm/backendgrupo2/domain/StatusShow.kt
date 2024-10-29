package ar.edu.unsam.phm.backendgrupo2.domain

import ar.edu.unsam.phm.backendgrupo2.dto.StatusShowDTO
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "status_show")
class StatusShow {
  
  companion object {
    
    fun fromJSON(statusShowDTO: StatusShowDTO): StatusShow =
      StatusShow().apply {
        this.id = statusShowDTO.id
        this.name = statusShowDTO.name
        this.profitStatusShowType = statusShowDTO.profitStatusShowType.toBigDecimal()
      }
  }
  
  @Id
  @GeneratedValue
  var id: Int = 0
  
  @Column(length = 40)
  var name: String = ""
  
  @Column
  var profitStatusShowType: BigDecimal = 0.toBigDecimal()
  
  fun profit(): BigDecimal =
    this.profitStatusShowType
}
package ar.edu.unsam.phm.backendgrupo2.domain

import ar.edu.unsam.phm.backendgrupo2.dto.PlaceOfShowDTO
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "place_of_show")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
abstract class PlaceOfShow {
	
	companion object {
		fun fromJSON(placeOfShowDTO: PlaceOfShowDTO): PlaceOfShow {
			val newPlaceOfShow: PlaceOfShow = if (placeOfShowDTO.type == "Stadium") {
				Stadium()
			} else {
				Theater()
			}
			return newPlaceOfShow.apply {
				this.id = placeOfShowDTO.id
				this.name = placeOfShowDTO.name
				this.type = placeOfShowDTO.type
				this.fixedCost = placeOfShowDTO.fixedCost.toBigDecimal()
				this.mapLocation = Location.fromJSON(placeOfShowDTO.mapLocation)
				this.hasGoodAcoustic = placeOfShowDTO.hasGoodAcoustic
			}
		}
	}
	
	@Id
	@GeneratedValue
	open var id: Int = 0
	
	@Column(length = 40)
	open var name: String = ""
	
	@Column(length = 40, name = "type", insertable = false, updatable = false)
	open var type: String = ""
	
	@Column
	open var fixedCost: BigDecimal = 0.toBigDecimal()
	
	@Column
	open var hasGoodAcoustic: Boolean = false
	
	@OneToOne
	open var mapLocation: Location? = null
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
	open var ticketsTypeList: MutableList<Ticket> = mutableListOf()
	
	fun locationCost(ticket: Ticket): BigDecimal =
		ticket.seatType!!.costSeatType
	
	fun amountOfPlaces(): Int =
		this.ticketsTypeList.sumOf { it.seatType!!.capacity }
	
	fun amountSeatsPerType(seatType: SeatType): Int =
		this.ticketsTypeList.find { it.seatType?.name == seatType.name }?.seatType?.capacity!!
	
	fun setTickets(newTickets: MutableList<Ticket>) {
		this.ticketsTypeList = newTickets
	}
	
	abstract fun baseCost(): BigDecimal
}

@Entity
@DiscriminatorValue("Stadium")
class Stadium : PlaceOfShow() {

	override fun baseCost(): BigDecimal =
		this.fixedCost
}

@Entity
@DiscriminatorValue("Theater")
class Theater: PlaceOfShow() {

	override fun baseCost(): BigDecimal =
		if(!this.hasGoodAcoustic) { this.fixedCost }
		else{ this.fixedCost + 50000.toBigDecimal() }
}
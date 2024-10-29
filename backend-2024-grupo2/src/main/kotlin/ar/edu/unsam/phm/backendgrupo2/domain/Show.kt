package ar.edu.unsam.phm.backendgrupo2.domain

import ar.edu.unsam.phm.backendgrupo2.dto.ShowDTO
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "show")
class Show {
	
	companion object {
		
		fun fromJSON(showDTO: ShowDTO): Show =
			Show().apply {
				this.id = showDTO.id
				this.bandName = showDTO.bandName
				this.placeOfShow = PlaceOfShow.fromJSON(showDTO.placeOfShow)
				this.nameOfRecital = showDTO.nameOfRecital
				this.costBand = showDTO.costBand.toBigDecimal()
				this.status = StatusShow.fromJSON(showDTO.status)
				this.image = showDTO.image
				this.functionShowList = showDTO.functionShow.map { FunctionShow.fromJSON(it) }.toMutableList()
			}
	}

	@Id
	@GeneratedValue
	var id: Int = 0

	@Column(length = 40)
	var bandName: String = ""

	@Column(length = 40)
	var nameOfRecital: String = ""
	
	@Column(length = 40)
	var image: String = ""

	@Column
	var costBand: BigDecimal = 0.toBigDecimal()

	@ManyToOne(fetch = FetchType.EAGER)
	var status: StatusShow? = null
	
	@ManyToOne(fetch = FetchType.EAGER)
	var placeOfShow: PlaceOfShow? = null

	@ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
	var functionShowList: MutableList<FunctionShow> = mutableListOf()
	
	@OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
	var commentList: MutableList<Comment> = mutableListOf()

	fun amountPeopleWaiting(): Int = 0

	fun amountFunctionSoldOut(): Int =
		this.functionShowList.count { it.isSoldOut() }

	fun totalSales(): BigDecimal =
		this.functionShowList.sumOf { it.totalSales() }
	
	fun score(): Double =
		if(this.commentList.size <= 0) 0.toDouble()
		else (this.commentList.sumOf { it.score } / this.commentList.size).toDouble()
	
	fun totalAmountOfTickets(): Int =
		this.functionShowList.sumOf { it.amountOfTicketsSold() }

	fun totalAmountOfTicketsPerSeatType(seatType: SeatType): Int =
		this.functionShowList.sumOf { it.ticketsBySeatType(seatType) }

	fun cost(): BigDecimal =
		this.placeOfShow!!.baseCost() + this.costBand

	fun minTicketPrice(): BigDecimal =
		if(this.functionShowList.isNotEmpty()) this.functionShowList.minOf { it.minTicketPrice() }
		else 0.toBigDecimal()

	fun maxTicketPrice(): BigDecimal =
		if(this.functionShowList.isNotEmpty()) this.functionShowList.maxOf { it.maxTicketPrice() }
		else 0.toBigDecimal()

	fun amountOfComments(): Int =
		this.commentList.size

	fun addCommentsToShow(comment: List<Comment>) {
		this.commentList.addAll(comment)
	}

	fun addComment(comment: Comment) {
		this.commentList.add(comment)
	}

	fun getComments(): List<Comment> =
		this.commentList

	fun addFunctionShow(functionShow: FunctionShow) {
		this.functionShowList.add(functionShow)
	}

	fun addFunctionsToShow(newFunctionShowList: List<FunctionShow>) {
		this.functionShowList.addAll(newFunctionShowList)
	}
	
	fun getCommentFromUser(user: User): List<Comment> =
		this.commentList.filter { it.owner?.id == user.id }

	fun userFriends(user: User): List<User> =
		user.getFriends().filter { it.getShows().contains(this) }

	fun userCommented(user: User): Boolean =
		this.commentList.any { it.owner?.id == user.id }

	fun hasComment(comment: Comment): Boolean =
		this.commentList.contains(comment)

	fun removeComment(comment: Comment) {
		this.commentList.remove(comment)
	}
}
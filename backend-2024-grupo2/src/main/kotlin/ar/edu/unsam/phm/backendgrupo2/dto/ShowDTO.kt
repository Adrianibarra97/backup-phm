package ar.edu.unsam.phm.backendgrupo2.dto

import ar.edu.unsam.phm.backendgrupo2.domain.*

data class ShowDTO(var show: Show, var user: User? = null) {
    var id: Int = show.id
    var bandName: String = show.bandName
    var placeOfShow: PlaceOfShowDTO = PlaceOfShowDTO(show.placeOfShow!!)
    var nameOfRecital: String = show.nameOfRecital
    var image: String = show.image
    var status: StatusShowDTO = StatusShowDTO(show.status!!)
    var costBand: Double = show.costBand.toDouble()
    var functionShow: List<FunctionShowDTO> = show.functionShowList.map { FunctionShowDTO(it) }
    var friendWithShow: List<UserFriendDTO> =
      if(user != null) { show.userFriends(user!!).map { UserFriendDTO(it) } }
      else { listOf() }
    var score: Double = show.score()
    var amountOfComments: Int = show.amountOfComments()
    var maxPrice: Double = show.maxTicketPrice().toDouble()
    var minPrice: Double = show.minTicketPrice().toDouble()
    var userCommented: Boolean =
      if(user != null) { show.userCommented(user!!) }
      else { false }
    var ticketPriceForUser: Double =
      if(user != null) { user?.ticketPriceForShow(show)!! }
      else { 0.0 }
}

data class DataShowAdministratorDTO(val functionShow: FunctionShow) {
    var totalAmountOfTickets: Int = functionShow.show?.totalAmountOfTickets()!!
    var amountOfTicketPerSeatType: List<SeatTypeDTO> = functionShow.show?.placeOfShow!!.ticketsTypeList.map {
        SeatTypeDTO(it.seatType!!, functionShow)
    }
    var totalSales: Double = functionShow.show?.totalSales()?.toDouble()!!
    var totalCost: Double = functionShow.show?.cost()?.toDouble()!!
    var amountPeopleWaiting: Int = functionShow.show?.amountPeopleWaiting()!!
    var profit: Double = functionShow.show?.status?.profit()?.toDouble()!!
    var amountFunctionsSoldOut: Int = functionShow.show?.amountFunctionSoldOut()!!
}

data class FilterShowsDTO(
  var bandName: String,
  var location: String,
  var byFriends: Boolean
)
package ar.edu.unsam.phm.backendgrupo2.repository

import ar.edu.unsam.phm.backendgrupo2.domain.*
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.jpa.repository.Query

interface ShowRepository : CrudRepository<Show, Int> {
  
  @EntityGraph(attributePaths = ["commentList"])
  override fun findAll(): List<Show>
  
  //@Query(value = ("SELECT s.* FROM show"), nativeQuery = true)
  // @EntityGraph(attributePaths = ["commentList"])
  //fun findAllByValidDate(): List<Show>
  
  // fun getShowsByFriends(user: User): List<Show> {
  //   return this.getAll().filter { it.userFriends(user).isNotEmpty() }
  // }
  
  // fun getShowsByFilterActive(user: User, filterWithFriends: FilterShowsDTO): List<Show> {
  //   if (filterWithFriends.byFriends) {
  //     return this.getShowsByFriends(user)
  //   }
  //   return this.getAll()
  // }

  // fun getShowsByFilter(filterWithFriends: FilterShowsDTO, user: User): List<Show> {
  //   if (filterWithFriends.bandName.isBlank() && filterWithFriends.location.isBlank()) {
  //     return this.getAll()
  //   }
  //   if (filterWithFriends.location.isBlank()) {
  //     return this.getShowsByFilterActive(user, filterWithFriends).filter {
  //       it.bandName.lowercase().contains(filterWithFriends.bandName.lowercase())
  //     }
  //   }
  //   if (filterWithFriends.bandName.isBlank()) {
  //     return this.getShowsByFilterActive(user, filterWithFriends).filter {
  //       it.placeOfShow!!.name.lowercase().contains(filterWithFriends.location.lowercase())
  //     }
  //   }
  //   return this.getShowsByFilterActive(user, filterWithFriends).filter {
  //     it.bandName.lowercase().contains(filterWithFriends.bandName.lowercase()) &&
  //     it.placeOfShow!!.name.lowercase().contains(filterWithFriends.location.lowercase())
  //   }
  // }

  // fun getShowsByFilterWithoutUser(filterWithFriends: FilterShowsDTO): List<Show> {
  //   if (filterWithFriends.bandName.isBlank() && filterWithFriends.location.isBlank()) {
  //     return this.getAll()
  //   }
  //   if (filterWithFriends.location.isBlank()) {
  //     return this.getAll().filter {
  //       it.bandName.lowercase().contains(filterWithFriends.bandName.lowercase())
  //     }
  //   }
  //   if (filterWithFriends.bandName.isBlank()) {
  //     return this.getAll().filter {
  //       it.placeOfShow!!.name.lowercase().contains(filterWithFriends.location.lowercase())
  //     }
  //   }
  //   return this.getAll().filter {
  //     it.bandName.lowercase().contains(filterWithFriends.bandName.lowercase()) &&
  //     it.placeOfShow!!.name.lowercase().contains(filterWithFriends.location.lowercase())
  //   }
  // }
}

interface UserRepository : CrudRepository<User, Int> {
  
  fun findByUsername(username: String): User
}

interface TicketRepository : CrudRepository<Ticket, Int> {
  
  fun findAllByIdAfter(id: Int): List<Ticket>
}

interface PlaceOfShowRepository : CrudRepository<PlaceOfShow, Int> {
  
  @EntityGraph(attributePaths = ["ticketsTypeList"])
  override fun findAll(): MutableIterable<PlaceOfShow>
}

interface StatusShowRepository : CrudRepository<StatusShow, Int> {}

interface LocationRepository : CrudRepository<Location, Int> {}

interface CommentRepository : CrudRepository<Comment, Int> {}

interface RoleRepository : CrudRepository<Role, Int> {}

interface SeatTypeRepository : CrudRepository<SeatType, Int> {}

interface FunctionShowRepository : CrudRepository<FunctionShow, Int> {
  
  @EntityGraph(attributePaths = ["ticketList"])
  override fun findAll(): MutableIterable<FunctionShow>
}
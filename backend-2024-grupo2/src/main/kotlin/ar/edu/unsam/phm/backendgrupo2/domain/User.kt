package ar.edu.unsam.phm.backendgrupo2.domain

import ar.edu.unsam.phm.backendgrupo2.dto.UserDTO
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "base_user")
class User {
  
  companion object {
    
    fun fromJSON(userDTO: UserDTO): User {
      val listDate = userDTO.birthOfDate.split("-")
      val newBirthOfDate = LocalDateTime.of(
        listDate[0].toInt(), listDate[1].toInt(), listDate[2].toInt(),
        listDate[3].toInt(), listDate[4].toInt(), listDate[5].toInt()
      )
      val newUser = User()
      newUser.id = userDTO.id
      newUser.name = userDTO.name
      newUser.surname = userDTO.surname
      newUser.username = userDTO.username
      newUser.imageUrl = userDTO.imageURL
      newUser.country = userDTO.country
      newUser.birthOfDate = newBirthOfDate
      newUser.role = Role.fromJSON(userDTO.role)
      newUser.dni = userDTO.dni
      newUser.password = userDTO.password
      newUser.availableMoney = userDTO.availableMoney.toBigDecimal()
      return newUser
    }
  }

  @Id
  @GeneratedValue
  var id: Int = 0

  @Column(length = 40)
  var name: String = ""

  @Column(length = 40)
  var surname: String = ""

  @Column(length = 40)
  var username: String = ""

  @Column(length = 40)
  var imageUrl: String = ""

  @Column(length = 40)
  var country: String = ""

  @Column
  var birthOfDate: LocalDateTime? = null

  @Column
  var dni: Int = 0

  @Column
  var password: Int = 0

  @Column
  var availableMoney: BigDecimal = 0.toBigDecimal()
  
  @Column
  var addCredit = 1000.toBigDecimal()

  @ManyToOne(fetch = FetchType.EAGER)
  var role: Role? = null
  
  @OneToMany(fetch = FetchType.LAZY)
  var ticketList: MutableList<Ticket> = mutableListOf()
  
  @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
  var friendList: MutableList<User> = mutableListOf()

  fun addFriend(newFriend: User) {
    this.friendList.add(newFriend)
  }

  fun addTicket(newTicket: Ticket) {
    this.ticketList.add(newTicket)
  }

  fun removeFriend(user: User) {
    if(!this.friendList.any { it.id == user.id }) throw NotFoundException("El amigo a eliminar no se encuentra!")
    this.friendList.remove(user)
  }

  fun removeTicket(ticket: Ticket) {
    if(!this.ticketList.any { it.id == ticket.id }) throw NotFoundException("El show a eliminar no se encuentra!")
    this.ticketList.remove(ticket)
  }

  fun getFriends(): MutableList<User> =
    this.friendList

  fun setFriends(newFriendList: MutableList<User>) {
    this.friendList = newFriendList
  }

  fun getShows(): List<Show> =
    this.ticketList.map { it.functionShow?.show!! }

  fun setTickets(newTicketList: MutableList<Ticket>) {
    this.ticketList = newTicketList
  }

  fun getComments(): List<Comment> =
    this.ticketList.map {
      it.functionShow?.show?.getCommentFromUser(this)!!
    }.flatten()

  fun addCredit() {
    this.availableMoney += this.addCredit
  }

  fun removeComment(comment: Comment) {
    this.showsContainsComment(comment).forEach { it.removeComment(comment) }
  }

  private fun showsContainsComment(comment: Comment): List<Show> {
    val ticketListWithComment: List<Ticket> = this.ticketList.filter { it.hasComment(comment) }
    return ticketListWithComment.map { it.functionShow?.show!! }
  }
  
  fun ticketPriceForShow(show: Show): Double {
    val ticketUser: Ticket? = this.ticketList.find { it.functionShow?.show == show }
    return ticketUser?.price()?.toDouble() ?: 0.0
  }
}
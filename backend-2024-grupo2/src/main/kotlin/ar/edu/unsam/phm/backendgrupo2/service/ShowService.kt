package ar.edu.unsam.phm.backendgrupo2.service

import ar.edu.unsam.phm.backendgrupo2.domain.*
import ar.edu.unsam.phm.backendgrupo2.dto.FilterShowsDTO
import ar.edu.unsam.phm.backendgrupo2.dto.FunctionShowDTO
import ar.edu.unsam.phm.backendgrupo2.dto.ShowDTO
import ar.edu.unsam.phm.backendgrupo2.repository.FunctionShowRepository
import ar.edu.unsam.phm.backendgrupo2.repository.PlaceOfShowRepository
import ar.edu.unsam.phm.backendgrupo2.repository.ShowRepository
import ar.edu.unsam.phm.backendgrupo2.repository.TicketRepository
import ar.edu.unsam.phm.backendgrupo2.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShowService : BaseService<Show> {

  @Autowired
  lateinit var repository: ShowRepository

  @Autowired
  lateinit var userRepository: UserRepository

  @Autowired
  lateinit var ticketRepository: TicketRepository

  @Autowired
  lateinit var functionShowRepository: FunctionShowRepository

  @Autowired
  lateinit var placeOfShowRepository: PlaceOfShowRepository

  @Transactional(Transactional.TxType.NEVER)
  override fun getAll(): List<Show> =
    // this.repository.findAllByValidDate()
    this.repository.findAll().toList()
    
  @Transactional(Transactional.TxType.NEVER)
  override fun getOneById(objectId: Int): Show =
    this.repository.findById(objectId).get()
  
  @Transactional(Transactional.TxType.NEVER)
  fun getTicketsOfFunctionShow(functionShowId: Int): List<Ticket> {
    val functionShow: FunctionShow = this.getFunctionShowById(functionShowId)
    return functionShow.ticketList.toList()
  }
  
  @Transactional(Transactional.TxType.NEVER)
  fun getComments(showId: Int): List<Comment> =
    this.repository.findById(showId).get().getComments()
  
  @Transactional(Transactional.TxType.NEVER)
  fun getAllPlacesOfShow(): List<PlaceOfShow> =
    this.placeOfShowRepository.findAll().toList()
  
  @Transactional(Transactional.TxType.NEVER)
  fun getFunctionShowById(functionShowId: Int): FunctionShow =
    this.functionShowRepository.findById(functionShowId).get()
  
  @Transactional(Transactional.TxType.NEVER)
  fun applyFilterWithoutUser(filterWithFriends: FilterShowsDTO): List<Show> {
    //Refactor filter in repository
    println(filterWithFriends)
    return this.repository.findAll().toList()
  }
  
  @Transactional(Transactional.TxType.NEVER)
  fun applyFilterWithUser(filterWithFriends: FilterShowsDTO, userId: Int): List<Show> {
    //Refactor filter in repository
    println(userId)
    println(filterWithFriends)
    return this.repository.findAll().toList()
  }
  
  @Transactional(Transactional.TxType.REQUIRED)
  override fun create(anObject: Show) {
    this.repository.save(anObject)
  }
  
  @Transactional(Transactional.TxType.REQUIRED)
  fun createNewFunctionShow(functionShowDTO: FunctionShowDTO) {
    val functionToCreate: FunctionShow = FunctionShow.fromJSON(functionShowDTO)
    this.functionShowRepository.save(functionToCreate)
    val functionCreated: FunctionShow = this.functionShowRepository.findAll().last()
    functionCreated.show?.addFunctionShow(functionCreated)
    this.repository.save(functionCreated.show!!)
  }
  
  @Transactional(Transactional.TxType.REQUIRED)
  override fun update(anObject: Show) {
    this.repository.save(anObject)
  }
  
  @Transactional(Transactional.TxType.REQUIRED)
  fun update(showDTO: ShowDTO) {
    val showForUpdate: Show = this.repository.findById(showDTO.id).get()
    val updatedShow: Show = Show.fromJSON(showDTO)
    updatedShow.id = showForUpdate.id
    updatedShow.functionShowList = showForUpdate.functionShowList
    updatedShow.commentList = showForUpdate.commentList
    this.repository.save(updatedShow)
  }
  
  @Transactional(Transactional.TxType.REQUIRED)
  fun buyTickets(user: User, functionShow: FunctionShow, ticketList: List<Ticket>) {
    this.ticketRepository.saveAll(ticketList.toMutableList())
    val newTickets: List<Ticket> = this.ticketRepository.findAllByIdAfter(this.repository.findAll().toList().size - ticketList.size)
    functionShow.addTicketsToFunction(newTickets)
    newTickets.forEach { user.addTicket(it) }
    this.functionShowRepository.save(functionShow)
    this.userRepository.save(user)
  }

  @Transactional(Transactional.TxType.REQUIRED)
  override fun delete(anObject: Show) {
    this.repository.delete(anObject)
  }
}
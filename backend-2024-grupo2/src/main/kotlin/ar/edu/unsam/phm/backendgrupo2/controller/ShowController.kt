package ar.edu.unsam.phm.backendgrupo2.controller

import ar.edu.unsam.phm.backendgrupo2.domain.*
import ar.edu.unsam.phm.backendgrupo2.dto.*
import ar.edu.unsam.phm.backendgrupo2.service.ShowService
import ar.edu.unsam.phm.backendgrupo2.service.UserService
import ar.edu.unsam.phm.backendgrupo2.util.DataValidator
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin("*")
class ShowController {

  @Autowired
  private lateinit var showService: ShowService

  @Autowired
  private lateinit var userService: UserService
  
  @GetMapping("/shows/all")
  @Operation(summary = "Returns shows without user logged.")
  fun getAllWithoutUser(): List<ShowDTO> =
    this.showService.getAll().map { ShowDTO(it) }
  
  @GetMapping("/shows/all/{id}")
  @Operation(summary = "Returns shows with user logged.")
  fun getAllWithUser(@PathVariable id: String): List<ShowDTO> {
    val user: User = this.userService.getOneById(id.toInt())
    return this.showService.getAll().map { ShowDTO(it, user) }
  }
  
  @GetMapping("/shows/{id}")
  @Operation(summary = "Return show by id.")
  fun getOneById(@PathVariable id: String): ShowDTO =
    ShowDTO(this.showService.getOneById(id.toInt()))
  
  @GetMapping("/shows/tickets/{functionShowId}")
  @Operation(summary = "Returns tickets to test buy-tickets endpoint.")
  fun getTicketsByFunctionShow(@PathVariable functionShowId: String): List<TicketDTO> =
    this.showService.getTicketsOfFunctionShow(functionShowId.toInt()).map { TicketDTO(it) }
  
  @GetMapping("/shows/comments/{id}")
  @Operation(summary = "Return the comments of a show.")
  fun getCommentsByShow(@PathVariable id: String): List<CommentDTO> =
    this.showService.getComments(id.toInt()).map{ CommentDTO(it) }

  @GetMapping("/shows/places-of-shows")
  @Operation(summary = "Returns possibles place of show to shows")
  fun getAllPlacesOfShow(): List<PlaceOfShowDTO> {
    return this.showService.getAllPlacesOfShow().map { PlaceOfShowDTO(it) }
  }

  @GetMapping("/shows/administrator-data/{functionShowId}")
  @Operation(summary = "Return the administrator data.")
  fun getAdministratorData(@PathVariable functionShowId: String): DataShowAdministratorDTO =
    DataShowAdministratorDTO(
      this.showService.getFunctionShowById(functionShowId.toInt())
    )
  
  @PostMapping("/shows/filter-by")
  @Operation(summary = "Returns shows filtered")
  fun getShowsFilterWithoutUser(@RequestBody filterShow: FilterShowsDTO): List<ShowDTO> =
    this.showService.applyFilterWithoutUser(filterShow).map { ShowDTO(it) }
  
  @PostMapping("/shows/filter-by/{userId}")
  @Operation(summary = "Returns shows filtered")
  fun getShowsFilterWithUser(@RequestBody filterShow: FilterShowsDTO, @PathVariable userId: String): List<ShowDTO> =
    this.showService.applyFilterWithUser(filterShow, userId.toInt()).map { ShowDTO(it) }
  
  @PostMapping("/shows/create-show")
  @Operation(summary = "Create a new show.")
  fun create(@RequestBody showDTO: ShowDTO) {
    DataValidator.someStringIsEmpty(listOf(
      showDTO.bandName, showDTO.image, showDTO.nameOfRecital
    ))
    DataValidator.someStringIsEmpty(showDTO.functionShow.map {
      it.hourOfFunction
    })
    showDTO.functionShow.forEach {
      DataValidator.stringIsValidToDate(it.hourOfFunction)
    }
    this.showService.create(Show.fromJSON(showDTO))
  }

  @PostMapping("/shows/create-function")
  @Operation(summary = "Create a new function to show.")
  fun createFunctionShow(@RequestBody functionShowDTO: FunctionShowDTO) {
    this.showService.createNewFunctionShow(functionShowDTO)
  }

  @PutMapping("/shows/update-show/{showId}")
  @Operation(summary = "Update a new show.")
  fun update(@RequestBody showDTO: ShowDTO, @PathVariable showId: String) {
    DataValidator.someStringIsEmpty(listOf(
      showDTO.bandName, showDTO.image, showDTO.nameOfRecital
    ))
    showDTO.id = showId.toInt()
    this.showService.update(showDTO)
  }

  @PutMapping("/shows/buy-tickets/{userId}/{showId}/{functionShowId}")
  @Operation(summary = "Buy tickets for a function.")
  fun buyTickets(
    @RequestBody ticketListDTO: List<TicketDTO>,
    @PathVariable userId: String,
    @PathVariable showId: String,
    @PathVariable functionShowId: String
  ) {
    val user: User = this.userService.getOneById(userId.toInt())
    val functionShow: FunctionShow = this.showService.getFunctionShowById(functionShowId.toInt())
    this.showService.buyTickets(
      user,
      functionShow,
      ticketListDTO.map { Ticket.fromJSON(it, functionShow) }
    )
  }

  @DeleteMapping("/shows/delete-shows/{id}")
  @Operation(summary = "Delete show by id")
  fun delete(@PathVariable id: String) {
    val showForDelete: Show = this.showService.getOneById(id.toInt())
    this.showService.delete(showForDelete)
  }
}




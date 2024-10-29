package ar.edu.unsam.phm.backendgrupo2.controller

import ar.edu.unsam.phm.backendgrupo2.domain.User
import ar.edu.unsam.phm.backendgrupo2.dto.*
import ar.edu.unsam.phm.backendgrupo2.service.UserService
import ar.edu.unsam.phm.backendgrupo2.util.DataValidator
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
class UserController {

  @Autowired
  private lateinit var userService: UserService

  @GetMapping("/user/all")
  @Operation(summary = "Returns all users in the system.")
  fun getAll(): List<UserDTO> =
    this.userService.getAll().map { UserDTO(it) }

  @GetMapping("/user/{id}")
  @Operation(summary = "Return user by id.")
  fun getOneById(@PathVariable id: String): UserDTO =
    UserDTO(this.userService.getOneById(id.toInt()))

  @GetMapping("/user/friend/{id}")
  @Operation(summary = "Returns users friends to user.")
  fun getFriendByUserId(@PathVariable id: String): List<UserFriendDTO> =
    this.userService.getFriends(id.toInt()).map { UserFriendDTO(it) }

  @GetMapping("/user/show/{id}")
  @Operation(summary = "Returns users friends to user.")
  fun getShowsByUserId(@PathVariable id: String): List<ShowDTO> {
    val user: User = userService.getOneById(id.toInt())
    return this.userService.getShows(id.toInt()).map { ShowDTO(it, user) }
  }

  @GetMapping("/user/comment/{id}")
  @Operation(summary = "Returns comments to user.")
  fun getCommentsByUserId(@PathVariable id: String): List<CommentDTO> =
    this.userService.getComments(id.toInt()).map { CommentDTO(it) }

  @GetMapping("/user/add-credit/{id}")
  @Operation(summary = "Add credit to user.")
  fun getAddCreditToUser(@PathVariable id: String) {
    this.userService.addCreditToUser(id.toInt())
  }

  @PostMapping("/user/create-user")
  @Operation(summary = "Create a new user.")
  fun create(@RequestBody userDTO: UserDTO) {
    DataValidator.someStringIsEmpty(listOf(
      userDTO.name, userDTO.surname, userDTO.username,
      userDTO.country, userDTO.imageURL
    ))
    DataValidator.stringIsValidToDate(userDTO.birthOfDate)
    this.userService.create(User.fromJSON(userDTO))
  }

  @PostMapping("/user/create-comment/{showId}/{userId}")
  @Operation(summary = "Create a comment to the user.")
  fun createCommentToUser(
    @RequestBody commentDTO: CommentDTO,
    @PathVariable showId: String,
    @PathVariable userId: String
  ) {
    DataValidator.someStringIsEmpty(listOf(
      commentDTO.description, commentDTO.bandName, commentDTO.imageShow
    ))
    DataValidator.stringIsValidToDate(commentDTO.dateComment)
    this.userService.createCommentForUser(commentDTO, showId.toInt(), userId.toInt())
  }

  @PostMapping("/login")
  @Operation(summary = "login to user.")
  fun login(@RequestBody body: UserLoginDTO): UserLoggedDTO =
    UserLoggedDTO(this.userService.searchUserByLoginData(body))
  
  @PutMapping("/user/update-user")
  @Operation(summary = "Update user.")
  fun update(@RequestBody userDTO: UserDTO) {
    DataValidator.someStringIsEmpty(listOf(
      userDTO.name, userDTO.surname, userDTO.username,
      userDTO.country, userDTO.imageURL, userDTO.birthOfDate
    ))
    DataValidator.stringIsValidToDate(userDTO.birthOfDate)
    this.userService.update(userDTO)
  }
  
  @DeleteMapping("/user/delete-user/{id}")
  @Operation(summary = "Delete user.")
  fun delete(@PathVariable id: String) {
    val userForDelete: User = this.userService.getOneById(id.toInt())
    this.userService.delete(userForDelete)
  }

  @DeleteMapping("/user/remove-friend/{friendId}/{userId}")
  @Operation(summary = "Remove friend to user.")
  fun removeFriendToUser(@PathVariable friendId: String, @PathVariable userId: String) {
    this.userService.removeFriend(friendId.toInt(), userId.toInt())
  }

  @DeleteMapping("/user/delete-comment/{commentId}/{userId}")
  @Operation(summary = "Remove comment from user.")
  fun deleteComment(
    @PathVariable commentId: String,
    @PathVariable userId: String
  ) {
    this.userService.removeComment(commentId.toInt(), userId.toInt())
  }
}
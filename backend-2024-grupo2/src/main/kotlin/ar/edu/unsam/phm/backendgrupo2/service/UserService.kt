package ar.edu.unsam.phm.backendgrupo2.service

import ar.edu.unsam.phm.backendgrupo2.domain.Comment
import ar.edu.unsam.phm.backendgrupo2.domain.Show
import ar.edu.unsam.phm.backendgrupo2.domain.User
import ar.edu.unsam.phm.backendgrupo2.dto.*
import ar.edu.unsam.phm.backendgrupo2.repository.CommentRepository
import ar.edu.unsam.phm.backendgrupo2.repository.ShowRepository
import ar.edu.unsam.phm.backendgrupo2.repository.UserRepository
import ar.edu.unsam.phm.backendgrupo2.util.DataValidator
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService : BaseService<User> {

  @Autowired
  lateinit var repository: UserRepository

  @Autowired
  lateinit var showRepository: ShowRepository

  @Autowired
  lateinit var commentRepository: CommentRepository

  @Transactional(Transactional.TxType.NEVER)
  override fun getAll(): List<User> =
    this.repository.findAll().toList()

  @Transactional(Transactional.TxType.NEVER)
  override fun getOneById(objectId: Int): User =
    this.repository.findById(objectId).get()
  
  @Transactional(Transactional.TxType.NEVER)
  fun getFriends(userId: Int): MutableList<User> =
    this.repository.findById(userId).get().getFriends()
  
  @Transactional(Transactional.TxType.NEVER)
  fun getShows(userId: Int): List<Show> =
    this.repository.findById(userId).get().getShows()
  
  @Transactional(Transactional.TxType.NEVER)
  fun getComments(userId: Int): List<Comment> =
    this.repository.findById(userId).get().getComments()
  
  @Transactional(Transactional.TxType.REQUIRED)
  fun addCreditToUser(id: Int) {
    val userToAddCredit: User = this.repository.findById(id).get()
    userToAddCredit.addCredit()
    this.repository.save(userToAddCredit)
  }
  
  @Transactional(Transactional.TxType.REQUIRED)
  override fun create(anObject: User) {
    anObject.availableMoney = 0.0.toBigDecimal()
    this.repository.save(anObject)
  }
  
  @Transactional(Transactional.TxType.REQUIRED)
  fun createCommentForUser(commentDTO: CommentDTO, showId: Int, userId: Int) {
    val user: User = this.repository.findById(userId).get()
    val show: Show = this.showRepository.findById(showId).get()
    val newComment: Comment = Comment.fromJSON(commentDTO, user, show)
    this.commentRepository.save(newComment)
    show.addComment(this.commentRepository.findAll().last())
    this.showRepository.save(show)
  }
  
  @Transactional(Transactional.TxType.NEVER)
  fun searchUserByLoginData(userDTO: UserLoginDTO): User {
    DataValidator.someStringIsEmpty(
      listOf(userDTO.username, userDTO.password.toString())
    )
    val userLogged: User = this.repository.findByUsername(userDTO.username)
    DataValidator.incorrectPassword(userLogged.password, userDTO.password)
    return userLogged
  }
  
  @Transactional(Transactional.TxType.REQUIRED)
  override fun update(anObject: User) {
    this.repository.save(anObject)
  }

  @Transactional(Transactional.TxType.REQUIRED)
  fun update(userDTO: UserDTO) {
    val userForUpdate: User = this.repository.findById(userDTO.id).get()
    val updatedUser: User = User.fromJSON(userDTO)
    updatedUser.id = userForUpdate.id
    updatedUser.password = userForUpdate.password
    updatedUser.availableMoney = userForUpdate.availableMoney
    updatedUser.setTickets(userForUpdate.ticketList)
    updatedUser.setFriends(userForUpdate.getFriends())
    this.repository.save(updatedUser)
  }
  
  @Transactional(Transactional.TxType.REQUIRED)
  override fun delete(anObject: User) {
    this.repository.delete(anObject)
  }
  
  @Transactional(Transactional.TxType.REQUIRED)
  fun removeFriend(friendId: Int, userId: Int) {
    val user: User = this.repository.findById(userId).get()
    val friendToRemove: User = this.repository.findById(friendId).get()
    user.removeFriend(friendToRemove)
  }

  @Transactional(Transactional.TxType.REQUIRED)
  fun removeComment(commentId: Int, userId: Int) {
    val user: User = this.repository.findById(userId).get()
    val comment: Comment = this.commentRepository.findById(commentId).get()
    user.removeComment(comment)
    this.commentRepository.delete(comment)
  }
}
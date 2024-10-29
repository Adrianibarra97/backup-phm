package ar.edu.unsam.phm.backendgrupo2.domain

import ar.edu.unsam.phm.backendgrupo2.dto.CommentDTO
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "comment")
class Comment {
  
  companion object {
    fun fromJSON(commentDTO: CommentDTO, user: User, show: Show): Comment {
      val newComment: Comment = Comment()
      newComment.id = commentDTO.id
      newComment.description = commentDTO.description
      newComment.dateComment = LocalDateTime.now()
      newComment.score = commentDTO.score
      newComment.show = show
      newComment.owner = user
      return newComment
    }
  }
  
  @Id
  @GeneratedValue
  var id: Int = 0
  
  @Column(length = 40)
  var description: String = ""
  
  @Column
  var score: Int = 0
  
  @Column
  var dateComment: LocalDateTime? = null
  
  @ManyToOne(fetch = FetchType.EAGER)
  var show: Show? = null
  
  @ManyToOne(fetch = FetchType.EAGER)
  var owner: User? = null
}
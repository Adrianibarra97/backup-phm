package ar.edu.unsam.phm.backendgrupo2.dto

import ar.edu.unsam.phm.backendgrupo2.domain.Comment

data class CommentDTO(val comment: Comment) {
  val id: Int = comment.id
  val bandName: String? = comment.show?.bandName
  val imageShow: String? = comment.show?.image
  val description: String = comment.description
  val score: Int = comment.score
  val dateComment: String = comment.dateComment.toString()
}
package org.sopt.doSopkathon.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponsePostDto(
    @SerialName("content")
    val content: String,
    @SerialName("createdAt")
    val createdAt: String,
    @SerialName("dayDiff")
    val dayDiff: Int,
    @SerialName("postId")
    val postId: Int,
    @SerialName("reviewList")
    val reviewList: List<Review>,
    @SerialName("title")
    val title: String
){
    @Serializable
    data class Review(
        @SerialName("review")
        val review: String,
        @SerialName("reviewDate")
        val reviewDate: String
    )
}
package org.sopt.doSopkathon.data.dto.response

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.time.LocalDateTime

@Serializable
data class ListResponseDto(
    @SerialName("postId")
    val postId: Int,
    @SerialName("title")
    val title: String,
    @SerialName("content")
    val content: String,
    @SerialName("createdAt")
    @Contextual
    val createdAt:LocalDate  ,
    @SerialName("categoryId")
    val categoryId: Long,
)
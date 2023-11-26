package org.sopt.doSopkathon.data.dto.response

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@Serializable
data class ListResponseDto(
    @SerialName("postId")
    val postId: Int,
    @SerialName("title")
    val title: String,
    @SerialName("content")
    val content: String,
    @Contextual
    @SerialName("createdAt")
    val createdAt:String,
    @SerialName("categoryId")
    val categoryId: Long,
)
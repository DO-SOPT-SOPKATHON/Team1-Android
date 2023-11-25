package org.sopt.doSopkathon.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WriteResponseDto(
    @SerialName("title")
    val title: String,
    @SerialName("content")
    val content: String,
    @SerialName("createdAt")
    val createdAt: String,
    @SerialName("categoryId")
    val categoryId: Int
)
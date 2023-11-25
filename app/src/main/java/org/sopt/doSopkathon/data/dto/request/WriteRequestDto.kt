package org.sopt.doSopkathon.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WriteRequestDto(
    @SerialName("categoryId")
    val categoryId: Int,
    @SerialName("title")
    val title: String,
    @SerialName("content")
    val content: String
)
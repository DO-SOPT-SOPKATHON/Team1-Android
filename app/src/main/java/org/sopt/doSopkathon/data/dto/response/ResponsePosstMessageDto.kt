package org.sopt.doSopkathon.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponsePostMessageDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String
)
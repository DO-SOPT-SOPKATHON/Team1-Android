package org.sopt.doSopkathon.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MockRequestDto(
    @SerialName("username")
    val username: String,
    @SerialName("password")
    val password: String
)
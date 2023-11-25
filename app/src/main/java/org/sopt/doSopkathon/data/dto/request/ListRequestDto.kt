package org.sopt.doSopkathon.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListRequestDto(
    @SerialName("categoryId")
    val categoryId: Long,
)
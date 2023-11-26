package org.sopt.doSopkathon.util.base

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val status: String,
    val message: String,
    val data: T? = null,
)
package org.sopt.doSopkathon.data.service

import org.sopt.doSopkathon.data.dto.request.WriteRequestDto
import org.sopt.doSopkathon.data.dto.response.WriteResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface WriteService {

    @POST("/api/post")
    suspend fun postWriteBody(
        @Body request: WriteRequestDto,
    ): Response<WriteResponseDto>

}
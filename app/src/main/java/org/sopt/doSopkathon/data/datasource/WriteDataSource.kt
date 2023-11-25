package org.sopt.doSopkathon.data.datasource

import org.sopt.doSopkathon.data.dto.request.WriteRequestDto
import org.sopt.doSopkathon.data.dto.response.WriteResponseDto
import org.sopt.doSopkathon.data.service.WriteService
import retrofit2.Response

class WriteDataSource(
    private val writeService: WriteService
) {
    suspend fun postWriteBody(
        requestDto: WriteRequestDto
    ): Response<WriteResponseDto> = writeService.postWriteBody(requestDto)
}
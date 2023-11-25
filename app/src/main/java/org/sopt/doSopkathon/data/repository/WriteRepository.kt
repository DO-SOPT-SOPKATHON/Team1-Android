package org.sopt.doSopkathon.data.repository

import org.sopt.doSopkathon.data.datasource.WriteDataSource
import org.sopt.doSopkathon.data.dto.request.WriteRequestDto
import org.sopt.doSopkathon.data.dto.response.WriteResponseDto
import retrofit2.Response

class WriteRepository(
    private val writeDataSource: WriteDataSource
) {
    suspend fun postWriteBody(
        requestDto: WriteRequestDto
    ): Response<WriteResponseDto> = writeDataSource.postWriteBody(requestDto)
}
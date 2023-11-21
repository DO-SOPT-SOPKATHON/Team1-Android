package org.sopt.doSopkathon.data.datasource

import org.sopt.doSopkathon.data.dto.response.MockResponseDto
import org.sopt.doSopkathon.data.service.MockService
import retrofit2.Response

class MockDataSource(
    private val mockService: MockService
) {

    suspend fun getCategory(): Response<MockResponseDto> =
        mockService.getSchoolList(1)

}
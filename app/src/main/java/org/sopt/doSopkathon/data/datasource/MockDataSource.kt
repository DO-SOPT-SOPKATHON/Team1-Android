package org.sopt.doSopkathon.data.datasource

import org.sopt.doSopkathon.data.service.MockService
import org.sopt.doSopkathon.data.service.ResponseUserListDto
import retrofit2.Response

class MockDataSource(
    private val mockService: MockService
) {
    suspend fun getCategory(): Response<ResponseUserListDto> =
        mockService.getMainPage(1)
}
package org.sopt.doSopkathon.data.repository

import org.sopt.doSopkathon.data.datasource.MockDataSource
import org.sopt.doSopkathon.data.dto.response.MockResponseDto
import retrofit2.Response

class MockRepository(
    private val mockDataSource: MockDataSource
) {

    suspend fun getCategory(): Response<MockResponseDto> {
        return mockDataSource.getCategory()
    }

}
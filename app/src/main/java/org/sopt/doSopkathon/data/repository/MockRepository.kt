package org.sopt.doSopkathon.data.repository

import org.sopt.doSopkathon.data.datasource.MockDataSource
import org.sopt.doSopkathon.data.service.ResponseUserListDto
import retrofit2.Response

class MockRepository(
    private val mockDataSource: MockDataSource
) {

    suspend fun getCategory(): Response<ResponseUserListDto> {
        return mockDataSource.getCategory()
    }

}
package org.sopt.doSopkathon.data.service

import org.sopt.doSopkathon.data.dto.request.MockRequestDto
import org.sopt.doSopkathon.data.dto.response.MockResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MockService {

    @POST("/post")
    suspend fun postToGetKakaoList(
        @Query("page") page: Int,
        @Body request: MockRequestDto
    ): Response<MockResponseDto>

    @GET("/get")
    suspend fun getSchoolList(
        @Query("page") page: Int
    ): Response<MockResponseDto>

}
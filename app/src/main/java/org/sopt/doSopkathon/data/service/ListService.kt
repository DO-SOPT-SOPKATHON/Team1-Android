package org.sopt.doSopkathon.data.service

import org.sopt.doSopkathon.data.dto.response.ListResponseDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ListService {
    @GET("api/post/category/{categoryId}")
    fun getListInfo(
        @Path("categoryId") categoryId: Long,
    ): Call<List<ListResponseDto>>
}
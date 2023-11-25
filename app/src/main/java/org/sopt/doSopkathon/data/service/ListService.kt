package org.sopt.doSopkathon.data.service

import org.sopt.doSopkathon.data.dto.response.ListResponseDto
import org.sopt.doSopkathon.util.base.BaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ListService {
    @GET("api/post/category/{categoryId}")
    fun getListInfo(
        @Path("categoryId") categoryId: Long,
    ): Call<BaseResponse<List<ListResponseDto>>>
}
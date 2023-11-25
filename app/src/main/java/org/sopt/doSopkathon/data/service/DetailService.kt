package org.sopt.doSopkathon.data.service

import org.sopt.doSopkathon.data.dto.ResponsePostDto
import org.sopt.doSopkathon.data.dto.request.ContentRequestDto
import org.sopt.doSopkathon.data.dto.response.ResponsePostMessageDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface DetailService {
    @GET("/api/post/{postId}")
    suspend fun getOnePost(
        @Path(value = "postId") postId:Int
    ): Response<ResponsePostDto>

    @GET("/api/post/random")
    suspend fun getRandomPost(
    ): Response<ResponsePostDto>

    @POST("/api/review/{postId}")
    suspend fun postAddReview(
        @Path("postId") postId: Int,
        @Body content: ContentRequestDto,
    ): Response<ResponsePostMessageDto>

}




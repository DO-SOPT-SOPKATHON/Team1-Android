package org.sopt.doSopkathon.data.repository

import org.sopt.doSopkathon.data.datasource.DetailDataSource
import org.sopt.doSopkathon.data.dto.ResponsePostDto
import org.sopt.doSopkathon.data.dto.response.ResponsePostMessageDto
import retrofit2.Response

class DetailRepository(
    private val detailDataSource: DetailDataSource
) {

    suspend fun getOnePost(postId: Int): Response<ResponsePostDto> =
        detailDataSource.getOnePost(postId)

    suspend fun getRandomPost(random: Int): Response<ResponsePostDto> =
        detailDataSource.getRandomPost(random)

    suspend fun addReview(contentRequestDto: String) : Response<ResponsePostMessageDto> =
        detailDataSource.postAddReview(contentRequestDto)

}
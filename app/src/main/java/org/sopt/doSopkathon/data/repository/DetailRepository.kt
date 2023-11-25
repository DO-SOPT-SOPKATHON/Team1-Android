package org.sopt.doSopkathon.data.repository

import org.sopt.doSopkathon.data.datasource.DetailDataSource
import org.sopt.doSopkathon.data.dto.ResponsePostDto
import org.sopt.doSopkathon.data.dto.response.ResponsePostMessageDto
import retrofit2.Response

class DetailRepository(
    private val detailDataSource: DetailDataSource,
) {

    suspend fun getOnePost(postId: Int): Response<ResponsePostDto> =
        detailDataSource.getOnePost(postId)

    suspend fun getRandomPost(): Response<ResponsePostDto> =
        detailDataSource.getRandomPost()

    suspend fun addReview(postId: Int,contentRequestDto: String): Response<ResponsePostMessageDto> =
        detailDataSource.postAddReview(postId,contentRequestDto)


    fun getMockPost(): ResponsePostDto {
        return ResponsePostDto(
            postId = 1,
            title = "오늘 길에 가다 넘어졌다",
            content = "무릎에 멍이 들까 걱정이 된다 흑",
            createdAt = "2023.11.09",
            dayDiff = 30,
            reviewList = listOf(
                ResponsePostDto.Review("멍이 안들었다!", "2023.11.20"),
                ResponsePostDto.Review("지금 봐도 다행이다~", "2023.11.21")
            )
        )
    }
}
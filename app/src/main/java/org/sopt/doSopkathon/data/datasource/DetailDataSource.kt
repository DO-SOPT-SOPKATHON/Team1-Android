package org.sopt.doSopkathon.data.datasource

import org.sopt.doSopkathon.data.dto.ResponsePostDto
import org.sopt.doSopkathon.data.dto.request.ContentRequestDto
import org.sopt.doSopkathon.data.dto.response.ResponsePostMessageDto
import org.sopt.doSopkathon.data.service.DetailService
import org.sopt.doSopkathon.data.service.MockService
import org.sopt.doSopkathon.data.service.ResponseUserListDto
import retrofit2.Response

class DetailDataSource(
    private val detailService: DetailService
) {
    suspend fun getOnePost(postId:Int): Response<ResponsePostDto> =
        detailService.getOnePost(postId)

    suspend fun getRandomPost(random:Int): Response<ResponsePostDto> =
        detailService.getRandomPost(random)

    suspend fun postAddReview(contentRequestDto: String) : Response<ResponsePostMessageDto> =
        detailService.postAddReview(ContentRequestDto(contentRequestDto))
}
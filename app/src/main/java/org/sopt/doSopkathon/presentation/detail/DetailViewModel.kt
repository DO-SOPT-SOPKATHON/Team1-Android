package org.sopt.doSopkathon.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.doSopkathon.data.dto.ResponsePostDto
import org.sopt.doSopkathon.data.repository.DetailRepository
import org.sopt.doSopkathon.data.repository.MockRepository

class DetailViewModel(
    private val repo: DetailRepository
) : ViewModel(
) {
    val _postViewData: MutableLiveData<ResponsePostDto> = MutableLiveData()
    val postViewData: LiveData<ResponsePostDto> get() = _postViewData

    val _addReviewResult: MutableLiveData<Boolean> = MutableLiveData()
    val addReviewResult: LiveData<Boolean> get() = _addReviewResult
    fun getOnePost(postId: Int) = viewModelScope.launch {
//        //mock ver
//        val data = repo.getMockPost()
//        _postViewData.value=data
        kotlin.runCatching { repo.getOnePost(postId) }.onSuccess {
            Log.d("success", "${it?.body()!!}")
            _postViewData.value = it?.body() ?: ResponsePostDto(
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
        }.onFailure {
            Log.d("fail", "$it")
        }
    }

    fun getRandomPost() = viewModelScope.launch {
//        //mock ver
//        val data = repo.getMockPost()
//        _postViewData.value=data
        kotlin.runCatching { repo.getRandomPost() }.onSuccess {
            Log.d("success", "${it?.body()}")
            _postViewData.value = it?.body() ?: ResponsePostDto(
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
        }.onFailure {
            Log.d("fail", "$it")
        }
    }

    fun addReview(postId: Int, review: String) = viewModelScope.launch {
        _addReviewResult.value = true
        kotlin.runCatching { repo.addReview(postId, review) }.onSuccess {
            Log.d("success", "${it?.body()?.code}")
        }.onFailure {
            Log.d("fail", "$it")
        }
    }
}
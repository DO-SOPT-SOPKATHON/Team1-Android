package org.sopt.doSopkathon.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.doSopkathon.data.dto.ResponsePostDto
import org.sopt.doSopkathon.data.repository.DetailRepository

class DetailViewModel(
    private val repo: DetailRepository
) : ViewModel(
) {
    private val _postViewData: MutableLiveData<ResponsePostDto> = MutableLiveData()
    val postViewData: LiveData<ResponsePostDto> get() = _postViewData

    private val _addReviewResult: MutableLiveData<Boolean> = MutableLiveData()
    val addReviewResult: LiveData<Boolean> get() = _addReviewResult

    fun getOnePost(postId: Int) = viewModelScope.launch {
        runCatching { repo.getOnePost(postId) }.onSuccess {
            _postViewData.value = it.body()
        }.onFailure {
            Log.d("fail", "$it")
        }
    }

    fun getRandomPost() = viewModelScope.launch {
        runCatching { repo.getRandomPost() }
            .onSuccess {
                _postViewData.value = it.body()
            }.onFailure {
                Log.d("fail", "$it")
            }
    }

    fun addReview(postId: Int, review: String) = viewModelScope.launch {
        runCatching { repo.addReview(postId, review) }.onSuccess {
            _addReviewResult.value = true
        }.onFailure {
            _addReviewResult.value = false
        }
    }
}
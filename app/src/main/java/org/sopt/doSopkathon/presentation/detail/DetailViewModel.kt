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
    val _postViewData :MutableLiveData<ResponsePostDto> = MutableLiveData()
    val postViewData : LiveData<ResponsePostDto> get() = _postViewData

    val _addReviewResult :MutableLiveData<Boolean> = MutableLiveData()
    val addReviewResult : LiveData<Boolean> get() = _addReviewResult
    fun getOnePost(postId:Int) = viewModelScope.launch {
        kotlin.runCatching { repo.getOnePost(postId) }.onSuccess {
//            Log.d("success", "${it?.body()!!}")
//            _postViewData.value=it?.body()!!
        }.onFailure {
            Log.d("fail", "$it")
        }
    }

    fun getRandomPost(random:Int) = viewModelScope.launch {
        kotlin.runCatching { repo.getRandomPost(random) }.onSuccess {
//            Log.d("success", "${it?.body()!!}")
        }.onFailure {
            Log.d("fail", "$it")
        }
    }

    fun addReview(review:String) = viewModelScope.launch {
        kotlin.runCatching { repo.addReview(review) }.onSuccess {
            Log.d("success", "${it?.body()?.code}")
            if (it?.body()?.code==200){
                Log.d("success","success")
                _addReviewResult.value=true
            }else{
                _addReviewResult.value=false
            }
        }.onFailure {
            Log.d("fail", "$it")
        }
    }
}
package org.sopt.doSopkathon.presentation.mock

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.doSopkathon.data.repository.MockRepository

class MockViewModel(
    private val repo: MockRepository
) : ViewModel(
) {
    fun test() = viewModelScope.launch {
        kotlin.runCatching { repo.getCategory() }.onSuccess {
            Log.d("success", "${it?.body()?.data}")
        }.onFailure {
            Log.d("fail", "$it")
        }
    }
}
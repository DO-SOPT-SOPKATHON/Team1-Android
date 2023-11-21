package org.sopt.doSopkathon.util

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
//            modelClass.isAssignableFrom(TestViewModel::class.java) -> {
//                val repository = TestRepo(TestRepoRemoteDataSource(ServicePool.testService))
//                TestViewModel(repository) as T
//            }
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel : ${modelClass.name}")
            }
        }
    }
}
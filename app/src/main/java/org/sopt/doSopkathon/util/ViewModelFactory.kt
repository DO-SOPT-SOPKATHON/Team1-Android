package org.sopt.doSopkathon.util

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.doSopkathon.api.ServicePool
import org.sopt.doSopkathon.data.datasource.MockDataSource
import org.sopt.doSopkathon.data.repository.MockRepository
import org.sopt.doSopkathon.presentation.MockViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MockViewModel::class.java) -> {
                val repository = MockRepository(MockDataSource(ServicePool.mockService))
                MockViewModel(repository) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel : ${modelClass.name}")
            }
        }
    }
}
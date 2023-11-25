package org.sopt.doSopkathon.util

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.doSopkathon.api.ServicePool
import org.sopt.doSopkathon.data.datasource.DetailDataSource
import org.sopt.doSopkathon.data.datasource.MockDataSource
import org.sopt.doSopkathon.data.datasource.WriteDataSource
import org.sopt.doSopkathon.data.repository.DetailRepository
import org.sopt.doSopkathon.data.repository.MockRepository
import org.sopt.doSopkathon.data.repository.WriteRepository
import org.sopt.doSopkathon.presentation.MockViewModel
import org.sopt.doSopkathon.presentation.write.WriteViewModel
import org.sopt.doSopkathon.presentation.detail.DetailViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MockViewModel::class.java) -> {
                val repository = MockRepository(MockDataSource(ServicePool.mockService))
                MockViewModel(repository) as T
            }
            modelClass.isAssignableFrom(WriteViewModel::class.java) -> {
                val repository = WriteRepository(WriteDataSource(ServicePool.writeService))
                WriteViewModel(repository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                val repository = DetailRepository(DetailDataSource(ServicePool.detailService))
                DetailViewModel(repository) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel : ${modelClass.name}")
            }
        }
    }
}
package org.sopt.doSopkathon.presentation.write

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.sopt.doSopkathon.data.dto.request.WriteRequestDto
import org.sopt.doSopkathon.data.dto.response.WriteResponseDto
import org.sopt.doSopkathon.data.repository.WriteRepository
import org.sopt.doSopkathon.util.UiState

class WriteViewModel(
    private val writeRepository: WriteRepository
) : ViewModel() {

    private val _postWriteBodyState = MutableStateFlow<UiState<WriteResponseDto?>>(UiState.Empty)
    val postWriteBodyState: StateFlow<UiState<WriteResponseDto?>> = _postWriteBodyState

    var categoryId = 0

    fun postWriteBodyToServer(requestDto: WriteRequestDto) {
        viewModelScope.launch {
            _postWriteBodyState.value = UiState.Loading
            runCatching {
                writeRepository.postWriteBody(requestDto)
            }.onSuccess {
                _postWriteBodyState.value = UiState.Success(it.body())
            }.onFailure {
                _postWriteBodyState.value = UiState.Failure(it.message.toString())
            }
        }
    }
}
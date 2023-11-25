package org.sopt.doSopkathon.presentation.write

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.sopt.doSopkathon.R
import org.sopt.doSopkathon.data.dto.request.WriteRequestDto
import org.sopt.doSopkathon.data.mock.categoryList
import org.sopt.doSopkathon.databinding.ActivityWriteBinding
import org.sopt.doSopkathon.util.UiState
import org.sopt.doSopkathon.util.ViewModelFactory
import org.sopt.doSopkathon.util.base.BindingActivity
import org.sopt.doSopkathon.util.extension.setOnSingleClickListener
import org.sopt.doSopkathon.util.extension.toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class WriteActivity : BindingActivity<ActivityWriteBinding>(R.layout.activity_write) {

    private val viewModel: WriteViewModel by viewModels { ViewModelFactory(this) }

    private var _adapter: WriteAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { getString(R.string.adapter_not_initialized_error_msg) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initAdapter()
        initSubmitBtnListener()
        setCurrentDate()
        observePostWriteBodyState()
    }

    private fun initAdapter() {
        _adapter = WriteAdapter { category, position ->
            // category ID 저장
            category.isSelected = !category.isSelected
            viewModel.categoryId = position + 1
            adapter.notifyItemChanged(position)
        }
        binding.rvWriteCategory.adapter = adapter
        adapter.submitList(categoryList)
    }

    private fun initSubmitBtnListener() {
        binding.btnWriteSubmit.setOnSingleClickListener {
            if (viewModel.categoryId == 0) {
                toast("카테고리를 선택해주세요")
            } else {
                binding.btnWriteSubmit.isSelected = !binding.btnWriteSubmit.isSelected
                viewModel.postWriteBodyToServer(
                    WriteRequestDto(
                        viewModel.categoryId,
                        binding.etWriteTitle.text.toString(),
                        binding.etWriteBody.text.toString()
                    )
                )
            }
        }
    }

    private fun observePostWriteBodyState() {
        viewModel.postWriteBodyState.flowWithLifecycle(lifecycle).onEach { state ->
            when (state) {
                is UiState.Success -> {
                    // TODO: 다이얼로그 전환
                }

                is UiState.Failure -> {
                    toast(getString(R.string.server_error))
                    binding.btnWriteSubmit.isSelected = !binding.btnWriteSubmit.isSelected
                }

                is UiState.Loading -> return@onEach

                is UiState.Empty -> return@onEach
            }
        }.launchIn(lifecycleScope)
    }

    private fun setCurrentDate() {
        val dateFormat = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault())
        binding.tvWriteDate.text = dateFormat.format(Calendar.getInstance().time)
    }

    private inline fun <reified T : Activity> navigateTo() {
        Intent(this@WriteActivity, T::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
        }
    }
}

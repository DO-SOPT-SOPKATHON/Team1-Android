package org.sopt.doSopkathon.presentation.write

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
import org.sopt.doSopkathon.presentation.detail.DetailActivity.Companion.EXTRA_CATEGORY
import org.sopt.doSopkathon.presentation.list.ListActivity
import org.sopt.doSopkathon.presentation.main.MainActivity
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
        _adapter = WriteAdapter { selectedCategory, position ->
            // category ID 저장
            selectedCategory.isSelected = !selectedCategory.isSelected
            for (category in categoryList.indices) {
                if (category != position) {
                    categoryList[category].isSelected = false
                    adapter.notifyItemChanged(category)
                }
            }
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
                    val dialog = WriteDialog(click = {
                        Intent(this, MainActivity::class.java).apply {
                            startActivity(this)
                        }
                    }, click2 = {
                        Intent(this, ListActivity::class.java).apply {
                            putExtra(EXTRA_CATEGORY, viewModel.categoryId)
                            startActivity(this)
                        }
                    })
                    dialog.show(supportFragmentManager, "MainDialog")
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
}

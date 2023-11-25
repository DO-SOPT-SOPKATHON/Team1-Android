package org.sopt.doSopkathon.presentation.write

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import org.sopt.doSopkathon.R
import org.sopt.doSopkathon.data.mock.categoryList
import org.sopt.doSopkathon.databinding.ActivityWriteBinding
import org.sopt.doSopkathon.util.base.BindingActivity
import org.sopt.doSopkathon.util.extension.setOnSingleClickListener

class WriteActivity : BindingActivity<ActivityWriteBinding>(R.layout.activity_write) {

    private var _adapter: WriteAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { getString(R.string.adapter_not_initialized_error_msg) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**  화면 이동 방법*
         *     binding.tvTest.setOnClickListener {
         *            navigateTo<WriteActivity>()
         *   }
         *   navigateTo<ListActivity>()
         *   navigateTo<WriteActivity>()
         *   navigateTo<DetailActivity>()
         * **/
        initAdapter()
        initSubmitBtnListener()
    }

    private fun initAdapter() {
        _adapter = WriteAdapter { category, position ->
            // category ID 저장
            category.isSelected = !category.isSelected
            adapter.notifyItemChanged(position)
        }
        binding.rvWriteCategory.adapter = adapter
        adapter.submitList(categoryList)
    }

    private fun initSubmitBtnListener() {
        binding.btnWriteSubmit.setOnSingleClickListener {
            binding.btnWriteSubmit.isSelected = !binding.btnWriteSubmit.isSelected
        }
    }

    private inline fun <reified T : Activity> navigateTo() {
        Intent(this@WriteActivity, T::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
        }
    }
}
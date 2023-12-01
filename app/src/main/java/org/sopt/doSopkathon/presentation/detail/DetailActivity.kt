package org.sopt.doSopkathon.presentation.detail

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import org.sopt.doSopkathon.R
import org.sopt.doSopkathon.databinding.ActivityDetailBinding
import org.sopt.doSopkathon.util.ViewModelFactory
import org.sopt.doSopkathon.util.base.NoHideBindingActivity
import org.sopt.doSopkathon.util.extension.hideKeyboard
import org.sopt.doSopkathon.util.extension.setOnSingleClickListener

class DetailActivity : NoHideBindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {

    private lateinit var detailAdapter: DetailAdapter
    private val viewModel: DetailViewModel by viewModels { ViewModelFactory(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initAdapter()
        spandableTextLayout()
    }

    private fun initView() {
        val postId = intent.getIntExtra(EXTRA_POST_ID, 404)
        val random = intent.getStringExtra(EXTRA_RANDOM)
        val category = intent.getLongExtra(EXTRA_CATEGORY, 0)
        when (category.toInt()) {
            0 -> binding.tvCategoryTitle.text = ""

            1 -> binding.tvCategoryTitle.text = "학업"

            2 -> binding.tvCategoryTitle.text = "연애"

            3 -> binding.tvCategoryTitle.text = "프로젝트"

            else -> binding.tvCategoryTitle.text = "취업"

        }
        if (postId != 404) viewModel.getOnePost(postId)
        if (random != null) viewModel.getRandomPost()
        observePostData()
        observeReviewResult(postId)
        sendReview(postId)
    }

    private fun initAdapter() {
        detailAdapter = DetailAdapter()
        binding.rvComment.adapter = detailAdapter
    }

    private fun observePostData() {
        viewModel.postViewData.observe(this) {
            binding.tvTitle.text = it.title
            binding.tvWriteDate1.text = it.createdAt
            binding.tvWriteDate2.text = it.createdAt
            binding.layoutDetail01.text = it.content
            binding.layoutDetail02.text = it.content
            detailAdapter.submitList(it.reviewList)
        }
    }

    private fun spandableTextLayout() {
        binding.ivAnimate.setOnSingleClickListener {
            val isDetail01Visible = binding.layoutDetail01.visibility == View.VISIBLE
            with(binding) {
                layoutDetail01.visibility = if (isDetail01Visible) View.GONE else View.VISIBLE
                layoutDetail02.visibility = if (isDetail01Visible) View.VISIBLE else View.GONE
                tvWriteDate1.visibility = if (isDetail01Visible) View.GONE else View.VISIBLE
                tvWriteDate2.visibility = if (isDetail01Visible) View.VISIBLE else View.GONE
                ivAnimate.animate().apply {
                    duration = 300
                    rotation(if (isDetail01Visible) 0f else 180f)
                }
            }
        }
    }

    private fun sendReview(postId: Int) {
        binding.ivChat.setOnSingleClickListener {
            viewModel.addReview(postId, binding.etvDetailSearch.text.toString())
            hideKeyboard(binding.root)
            binding.etvDetailSearch.setText("")
        }
    }

    private fun observeReviewResult(postId: Int) {
        viewModel.addReviewResult.observe(this) { result ->
            if (result) {
                viewModel.getOnePost(postId)
                detailAdapter.notifyDataSetChanged()
                binding.rvComment.smoothScrollToPosition(detailAdapter.itemCount - 1)
            }
        }
    }

    companion object {
        const val EXTRA_POST_ID = "dataPostId"
        const val EXTRA_RANDOM = "random"
        const val EXTRA_CATEGORY = "category"
    }
}
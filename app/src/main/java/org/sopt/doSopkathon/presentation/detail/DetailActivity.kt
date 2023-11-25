package org.sopt.doSopkathon.presentation.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import org.sopt.doSopkathon.R
import org.sopt.doSopkathon.databinding.ActivityDetailBinding
import org.sopt.doSopkathon.util.ViewModelFactory
import org.sopt.doSopkathon.util.base.NoHideBindingActivity

class DetailActivity : NoHideBindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {

    private lateinit var detailAdapter: DetailAdapter
    private val viewModel: DetailViewModel by viewModels { ViewModelFactory(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initAdapter()
        observePostData()
        spandableTextLayout()
        binding.ivChat.setOnClickListener {
            Log.d("Detail", binding.etvDetailSearch.text.toString())
            viewModel.addReview(binding.etvDetailSearch.text.toString())
        }
    }

    private fun initView() {
        val postId = intent.getIntExtra("dataPostId", 4044)
        val random = intent.getIntExtra("random", 4044)
        Log.d("detail","$postId,$random")
        if (postId != 4044) viewModel.getOnePost(postId)
        if (random != 4044) viewModel.getRandomPost(random)
    }

    private fun initAdapter() {
        detailAdapter = DetailAdapter()
        binding.rvComment.adapter = detailAdapter
    }

    private fun observePostData() {
        viewModel.postViewData.observe(this) {
            detailAdapter.submitList(it.reviewList)
        }
    }

    private fun spandableTextLayout() {
        binding.ivAnimate.setOnClickListener {
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

    private inline fun <reified T : Activity> navigateTo() {
        Intent(this@DetailActivity, T::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
        }
    }
}
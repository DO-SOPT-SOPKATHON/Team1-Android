package org.sopt.doSopkathon.presentation.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import org.sopt.doSopkathon.R
import org.sopt.doSopkathon.databinding.ActivityDetailBinding
import org.sopt.doSopkathon.util.base.NoHideBindingActivity

class DetailActivity : NoHideBindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {

    private lateinit var detailAdapter: DetailAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = intent.getIntExtra("data", 1)

        detailAdapter = DetailAdapter()
        binding.rvComment.adapter = detailAdapter
        detailAdapter.submitList(
            listOf(
                MockComment("1", "tadsasdasd", "fqweqwe"),
                MockComment("1", "tadsawdasdasdasdasd", "fqweqwe"),
                MockComment("1", "tadasdasdasdsasdasd", "fqweqwe"),
                MockComment("1", "tadsasdasd", "fqweqwe"),
            )
        )
        spandableTextLayout()
    }

    private fun spandableTextLayout() {
        binding.tvTitle.setOnClickListener {
            val isDetail01Visible = binding.layoutDetail01.visibility == View.VISIBLE

            with(binding) {
                layoutDetail01.visibility = if (isDetail01Visible) View.GONE else View.VISIBLE
                layoutDetail02.visibility = if (isDetail01Visible) View.VISIBLE else View.GONE
                tvWriteDate1.visibility = if (isDetail01Visible) View.GONE else View.VISIBLE
                tvWriteDate2.visibility = if (isDetail01Visible) View.VISIBLE else View.GONE

                tvTitle.animate().apply {
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
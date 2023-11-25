package org.sopt.doSopkathon.presentation.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import org.sopt.doSopkathon.R
import org.sopt.doSopkathon.databinding.ActivityDetailBinding
import org.sopt.doSopkathon.util.base.BindingActivity

class DetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private inline fun <reified T : Activity> navigateTo() {
        Intent(this@DetailActivity, T::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
        }
    }
}
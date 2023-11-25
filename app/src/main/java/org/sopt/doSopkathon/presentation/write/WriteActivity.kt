package org.sopt.doSopkathon.presentation.write

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import org.sopt.doSopkathon.R
import org.sopt.doSopkathon.databinding.ActivityWriteBinding
import org.sopt.doSopkathon.util.base.BindingActivity

class WriteActivity : BindingActivity<ActivityWriteBinding>(R.layout.activity_write) {

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
    }

    private inline fun <reified T : Activity> navigateTo() {
        Intent(this@WriteActivity, T::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
        }
    }
}
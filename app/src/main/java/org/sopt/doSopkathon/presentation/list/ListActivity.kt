package org.sopt.doSopkathon.presentation.list

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import org.sopt.doSopkathon.R
import org.sopt.doSopkathon.data.mock.mockListList
import org.sopt.doSopkathon.databinding.ActivityListBinding
import org.sopt.doSopkathon.util.base.BindingActivity

class ListActivity : BindingActivity<ActivityListBinding>(R.layout.activity_list) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mockListList
        val ListAdapter = ListAdapter(this)
        binding.rvListList.adapter = ListAdapter
        ListAdapter.setListList(mockListList)
        /**  화면 이동 방법*
         *     binding.tvTest.setOnClickListener {
         *            navigateTo<DetailActivity>()
         *   }
         *   navigateTo<DetailActivity>()
         * **/
    }

    private inline fun <reified T : Activity> navigateTo() {
        Intent(this@ListActivity, T::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
        }
    }
}
package org.sopt.doSopkathon.presentation.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import org.sopt.doSopkathon.R
import org.sopt.doSopkathon.data.mock.categoryList
import org.sopt.doSopkathon.databinding.ActivityMainBinding
import org.sopt.doSopkathon.presentation.detail.DetailActivity
import org.sopt.doSopkathon.presentation.detail.DetailActivity.Companion.EXTRA_CATEGORY
import org.sopt.doSopkathon.presentation.detail.DetailActivity.Companion.EXTRA_POST_ID
import org.sopt.doSopkathon.presentation.detail.DetailActivity.Companion.EXTRA_RANDOM
import org.sopt.doSopkathon.presentation.list.ListActivity
import org.sopt.doSopkathon.presentation.write.WriteActivity
import org.sopt.doSopkathon.util.base.BindingActivity
import org.sopt.doSopkathon.util.extension.setOnSingleClickListener

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showRandomWorryDialog()
        initRecyclerView()
        clickWriteWorryBtn()
        clickListWorryBtn()
    }

    private fun showRandomWorryDialog() {
        val dialog = MainDialog(click = {
            Intent(this, DetailActivity::class.java).apply {
                putExtra(EXTRA_RANDOM, 1)
                startActivity(this)
            }
        })
        dialog.show(supportFragmentManager, getString(R.string.binding_not_initialized_error_msg))
    }

    private fun initRecyclerView() {
        binding.rvMainWorryCollectionBox.adapter = MainAdapter(categoryList, Click = {
            Intent(this, ListActivity::class.java).apply {
                putExtra(EXTRA_CATEGORY, it.id.toLong())
                startActivity(this)
            }
        })
    }

    private fun clickListWorryBtn() {
        binding.btnMainWatchWorry.setOnSingleClickListener {
            navigateTo<DetailActivity>()
        }
    }

    private fun clickWriteWorryBtn() {
        binding.fabMainWriteWorry.setOnSingleClickListener {
            navigateTo<WriteActivity>()
        }
    }

    private inline fun <reified T : Activity> navigateTo() {
        Intent(this@MainActivity, T::class.java).apply {
            putExtra(EXTRA_RANDOM, 1)
            putExtra(EXTRA_POST_ID, 1)
            startActivity(this)
        }
    }
}

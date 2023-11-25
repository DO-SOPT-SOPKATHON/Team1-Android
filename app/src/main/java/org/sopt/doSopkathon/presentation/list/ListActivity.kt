package org.sopt.doSopkathon.presentation.list

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import org.sopt.doSopkathon.R
import org.sopt.doSopkathon.api.ServicePool
import org.sopt.doSopkathon.data.dto.response.ListResponseDto
import org.sopt.doSopkathon.databinding.ActivityListBinding
import org.sopt.doSopkathon.presentation.detail.DetailActivity
import org.sopt.doSopkathon.util.base.BindingActivity
import retrofit2.Call
import retrofit2.Response

class ListActivity : BindingActivity<ActivityListBinding>(R.layout.activity_list) {

    private var _adapter: ListAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { getString(R.string.adapter_not_initialized_error_msg) }

    // TODO: 카테고리 설정
    private val categoryId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
        val categoryId = intent.getLongExtra("category",1)
        getListInfo(categoryId)
    }

    private inline fun <reified T : Activity> navigateTo() {
        Intent(this@ListActivity, T::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
        }
    }

    private fun initAdapter() {
        _adapter = ListAdapter(this, Click = {
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("dataPostId", it.postId)
            }
            startActivity(intent)
        })
        binding.rvListList.adapter = adapter
    }

    private fun getListInfo(category:Long) {
        ServicePool.listService.getListInfo(category)
            .enqueue(object : retrofit2.Callback<List<ListResponseDto>> {
                override fun onResponse(
                    call: Call<List<ListResponseDto>>,
                    response: Response<List<ListResponseDto>>,
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()!!
                        adapter.setListList(data)
                    } else {
                        Toast.makeText(this@ListActivity, "서버 통신 실패", Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<List<ListResponseDto>>, t: Throwable) {
                    Toast.makeText(this@ListActivity, "서버 에러 발생", Toast.LENGTH_SHORT).show()
                }
            })

    }


}

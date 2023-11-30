package org.sopt.doSopkathon.presentation.list

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.sopt.doSopkathon.R
import org.sopt.doSopkathon.api.ServicePool
import org.sopt.doSopkathon.data.dto.response.ListResponseDto
import org.sopt.doSopkathon.databinding.ActivityListBinding
import org.sopt.doSopkathon.presentation.detail.DetailActivity
import org.sopt.doSopkathon.util.base.BaseResponse
import org.sopt.doSopkathon.util.base.BindingActivity
import retrofit2.Call
import retrofit2.Response

class ListActivity : BindingActivity<ActivityListBinding>(R.layout.activity_list) {

    private var _adapter: ListAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { getString(R.string.adapter_not_initialized_error_msg) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
        val categoryId = intent.getLongExtra("category", 1)
        Log.d("category", "$categoryId")
        when (categoryId.toInt()) {
            1 -> {
                binding.tvListCategoryName.text = "학업"

            }

            2 -> {
                binding.tvListCategoryName.text = "연애"
            }

            3 -> {
                binding.tvListCategoryName.text = "프로젝트"
            }

            else -> {
                binding.tvListCategoryName.text = "취업"

            }
        }
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
                putExtra("category", it.categoryId)
                Log.d("categort", "${it.categoryId}")
            }
            startActivity(intent)
        })
        binding.rvListList.adapter = adapter
    }

    private fun getListInfo(category: Long) {
        ServicePool.listService.getListInfo(category)
            .enqueue(object : retrofit2.Callback<BaseResponse<List<ListResponseDto>>> {
                override fun onFailure(
                    call: Call<BaseResponse<List<ListResponseDto>>>,
                    t: Throwable
                ) {

                    Log.d("test", "$t")
//                    Toast.makeText(this@ListActivity, "서버 에러 발생", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<BaseResponse<List<ListResponseDto>>>,
                    response: Response<BaseResponse<List<ListResponseDto>>>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()!!
                        adapter.setListList(data.data!!)
                        Log.d("test", "$data")
                    } else {
                        Log.d("test", "${response.errorBody()}")
                        Toast.makeText(this@ListActivity, "서버 통신 실패", Toast.LENGTH_SHORT).show()
                    }
                }
            })

    }


}

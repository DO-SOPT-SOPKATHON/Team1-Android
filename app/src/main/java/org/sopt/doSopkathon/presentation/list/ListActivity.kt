package org.sopt.doSopkathon.presentation.list

import android.content.Intent
import android.os.Bundle
import org.sopt.doSopkathon.R
import org.sopt.doSopkathon.api.ServicePool
import org.sopt.doSopkathon.data.dto.response.ListResponseDto
import org.sopt.doSopkathon.databinding.ActivityListBinding
import org.sopt.doSopkathon.presentation.detail.DetailActivity
import org.sopt.doSopkathon.presentation.detail.DetailActivity.Companion.EXTRA_CATEGORY
import org.sopt.doSopkathon.presentation.detail.DetailActivity.Companion.EXTRA_POST_ID
import org.sopt.doSopkathon.util.base.BaseResponse
import org.sopt.doSopkathon.util.base.BindingActivity
import org.sopt.doSopkathon.util.extension.toast
import retrofit2.Call
import retrofit2.Response

class ListActivity : BindingActivity<ActivityListBinding>(R.layout.activity_list) {

    private var _adapter: ListAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { getString(R.string.adapter_not_initialized_error_msg) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
        setCategory()

    }

    private fun setCategory() {
        val categoryId = intent.getLongExtra(EXTRA_CATEGORY, 0)
        when (categoryId.toInt()) {
            1 -> binding.tvListCategoryName.text = "학업"

            2 -> binding.tvListCategoryName.text = "연애"

            3 -> binding.tvListCategoryName.text = "프로젝트"

            4 -> binding.tvListCategoryName.text = "취업"

            else -> binding.tvListCategoryName.text = ""
        }
        getListInfo(categoryId)
    }

    private fun initAdapter() {
        _adapter = ListAdapter(this, Click = {
            Intent(this, DetailActivity::class.java).apply {
                putExtra(EXTRA_POST_ID, it.postId)
                putExtra(EXTRA_CATEGORY, it.categoryId)
                startActivity(this)
            }
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
                    toast("서버 에러 발생")
                }

                override fun onResponse(
                    call: Call<BaseResponse<List<ListResponseDto>>>,
                    response: Response<BaseResponse<List<ListResponseDto>>>
                ) {
                    if (response.isSuccessful) {
                        val responseData = response.body()?.data ?: return
                        adapter.setListList(responseData)
                    } else {
                        toast("서버 통신 실패")
                    }
                }
            })

    }


}

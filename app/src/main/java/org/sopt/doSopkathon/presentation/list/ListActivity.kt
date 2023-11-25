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
import org.sopt.doSopkathon.util.base.BindingActivity
import retrofit2.Call
import retrofit2.Response

class ListActivity : BindingActivity<ActivityListBinding>(R.layout.activity_list) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val category = intent.getStringExtra("category")
        Log.d("List","$category")
        val ListAdapter = ListAdapter(this)
        binding.rvListList.adapter = ListAdapter
        /**  화면 이동 방법*
         *     binding.tvTest.setOnClickListener {
         *            navigateTo<DetailActivity>()
         *   }
         *   navigateTo<DetailActivity>()
         * **/
        getListInfo()
    }

    private inline fun <reified T : Activity> navigateTo() {
        Intent(this@ListActivity, T::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
        }
    }

    fun initAdapter(data: List<ListResponseDto>) {

        val ListAdapter = ListAdapter(this)
        binding.rvListList.adapter = ListAdapter
        ListAdapter.setListList(data)
    }

    private fun getListInfo() {
        val categoryName = binding.tvListCategoryName.text
        Log.d("ListActivity", "Sending request to the server with categoryId: $categoryName")

        ServicePool.listService.getListInfo(1)
            .enqueue(object : retrofit2.Callback<List<ListResponseDto>> {
                override fun onResponse(
                    call: Call<List<ListResponseDto>>,
                    response: Response<List<ListResponseDto>>,
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()!!
                        Log.d("ListActivity", "Received successful response from the server: $data")
                        initAdapter(data)
                    }
                    else {
                        Log.e("ListActivity", "Server returned an error: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<List<ListResponseDto>>, t: Throwable) {
                    Log.e("ListActivity", "Error during API call", t)
                    Toast.makeText(this@ListActivity, "서버 에러 발생", Toast.LENGTH_SHORT).show()
                }
            })

    }


}

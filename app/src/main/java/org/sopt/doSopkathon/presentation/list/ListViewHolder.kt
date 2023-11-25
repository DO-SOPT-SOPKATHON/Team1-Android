package org.sopt.doSopkathon.presentation.list

import androidx.recyclerview.widget.RecyclerView
import org.sopt.doSopkathon.data.dto.response.ListResponseDto
import org.sopt.doSopkathon.databinding.ItemListBinding

class ListViewHolder(
    private val binding: ItemListBinding,
    private val Click: (ListResponseDto) -> Unit = { _ -> }
) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(listData: ListResponseDto) {
        binding.tvListTitle.text = listData.title
        binding.tvListContent.text = listData.content
        binding.tvListDate.text = listData.createdAt.toString()
        binding.root.setOnClickListener {
            Click(listData)
        }
    }
}
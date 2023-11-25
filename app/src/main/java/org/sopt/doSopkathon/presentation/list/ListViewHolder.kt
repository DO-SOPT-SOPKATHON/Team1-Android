package org.sopt.doSopkathon.presentation.list

import androidx.recyclerview.widget.RecyclerView
import org.sopt.doSopkathon.data.dataclass.List_DataClass
import org.sopt.doSopkathon.databinding.ItemListBinding

class ListViewHolder(private val binding: ItemListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(listData: List_DataClass) {
        binding.tvListTitle.text = listData.title
        binding.tvListContent.text = listData.content
        binding.tvListDate.text = listData.date
    }
}
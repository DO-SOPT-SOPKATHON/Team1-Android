package org.sopt.doSopkathon.presentation.main

import androidx.recyclerview.widget.RecyclerView
import org.sopt.doSopkathon.data.dataclass.Category
import org.sopt.doSopkathon.databinding.ItemMainBinding

class MainViewHolder(private val binding: ItemMainBinding,private val click: (Category) -> Unit = { _ -> }) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(category: Category) {
        binding.tvMainCategoryName.text = category.name
        binding.root.setOnClickListener {
            click(category)
        }
    }
}
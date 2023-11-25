package org.sopt.doSopkathon.presentation.write

import androidx.recyclerview.widget.RecyclerView
import org.sopt.doSopkathon.data.datasource.Category
import org.sopt.doSopkathon.databinding.ItemWriteCategoryBinding
import org.sopt.doSopkathon.util.extension.setOnSingleClickListener

class SearchViewHolder(
    private val binding: ItemWriteCategoryBinding,
    private val itemClick: (Category, Int) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: Category, position: Int) {
        binding.tvCategoryName.text = item.name
        binding.tvCategoryName.isSelected = item.isSelected

        binding.tvCategoryName.setOnSingleClickListener {
            itemClick(item, position)
        }
    }
}
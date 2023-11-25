package org.sopt.doSopkathon.presentation.detail

import androidx.recyclerview.widget.RecyclerView
import org.sopt.doSopkathon.databinding.ItemCommentBinding

class DetailViewHolder(
    private val binding: ItemCommentBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: MockComment) {
        binding.comment = data
        binding.executePendingBindings()
    }
}
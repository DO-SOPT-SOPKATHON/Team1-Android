package org.sopt.doSopkathon.presentation.detail

import androidx.recyclerview.widget.RecyclerView
import org.sopt.doSopkathon.data.dto.ResponsePostDto
import org.sopt.doSopkathon.databinding.ItemCommentBinding

class DetailViewHolder(
    private val binding: ItemCommentBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: ResponsePostDto.Review) {
        binding.comment = data
        binding.executePendingBindings()
    }
}
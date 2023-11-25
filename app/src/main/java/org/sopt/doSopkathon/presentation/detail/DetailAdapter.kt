package org.sopt.doSopkathon.presentation.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.doSopkathon.data.dto.ResponsePostDto
import org.sopt.doSopkathon.databinding.ItemCommentBinding
import org.sopt.doSopkathon.util.extension.ItemDiffCallback

class DetailAdapter(
) : ListAdapter<ResponsePostDto.Review, DetailViewHolder>(
    HighLightDiffCalback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val binding =
            ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val HighLightDiffCalback =
            ItemDiffCallback<ResponsePostDto.Review>(
                onItemsTheSame = { old, new -> old.review == new.review },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}
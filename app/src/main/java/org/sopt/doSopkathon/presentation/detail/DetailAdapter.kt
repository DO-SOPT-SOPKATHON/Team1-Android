package org.sopt.doSopkathon.presentation.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.doSopkathon.databinding.ItemCommentBinding
import org.sopt.doSopkathon.util.extension.ItemDiffCallback

class DetailAdapter(
) : ListAdapter<MockComment, DetailViewHolder>(
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
            ItemDiffCallback<MockComment>(
                onItemsTheSame = { old, new -> old.img == new.img },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}
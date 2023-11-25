package org.sopt.doSopkathon.presentation.main

import androidx.recyclerview.widget.RecyclerView
import org.sopt.doSopkathon.databinding.ItemMainBinding

class MainViewHolder(private val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind() {
        binding.tvMainCategoryName.text // = 어쩌구 .. 넣기
    }
}
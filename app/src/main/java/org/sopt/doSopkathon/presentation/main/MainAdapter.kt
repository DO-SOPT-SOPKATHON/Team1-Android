package org.sopt.doSopkathon.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.doSopkathon.data.dataclass.Category
import org.sopt.doSopkathon.databinding.ItemMainBinding

class MainAdapter(private val categoryList: List<Category>,private val Click: (Category) -> Unit = { _ -> }) :
    RecyclerView.Adapter<MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding,Click)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(categoryList[position])
    }

    override fun getItemCount(): Int = categoryList.size
}

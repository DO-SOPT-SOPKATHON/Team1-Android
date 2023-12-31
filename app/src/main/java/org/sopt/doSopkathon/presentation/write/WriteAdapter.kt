package org.sopt.doSopkathon.presentation.write

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.doSopkathon.data.dataclass.Category
import org.sopt.doSopkathon.databinding.ItemWriteCategoryBinding
import org.sopt.doSopkathon.util.extension.ItemDiffCallback

class WriteAdapter(
    private val itemClick: (Category, Int) -> Unit
) : ListAdapter<Category, WriteViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WriteViewHolder {
        val inflater by lazy { LayoutInflater.from(parent.context) }
        val binding: ItemWriteCategoryBinding =
            ItemWriteCategoryBinding.inflate(inflater, parent, false)
        return WriteViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: WriteViewHolder, position: Int) {
        val item = getItem(position) ?: return
        holder.onBind(item, position)
    }

    companion object {
        private val diffUtil = ItemDiffCallback<Category>(
            onItemsTheSame = { old, new -> old.id == new.id },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}
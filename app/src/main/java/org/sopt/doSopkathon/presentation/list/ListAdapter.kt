package org.sopt.doSopkathon.presentation.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.doSopkathon.data.dataclass.Category
import org.sopt.doSopkathon.data.dto.response.ListResponseDto
import org.sopt.doSopkathon.databinding.ItemListBinding

class ListAdapter(
    context: Context,
    private val Click: (ListResponseDto) -> Unit = { _ -> }
) : RecyclerView.Adapter<ListViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var listList: List<ListResponseDto> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemListBinding.inflate(inflater, parent, false)
        return ListViewHolder(binding,Click)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.onBind(listList[position])
    }

    override fun getItemCount() = listList.size

    fun setListList(listList: List<ListResponseDto>) {
        this.listList = listList.toList()
        notifyDataSetChanged()
    }
}
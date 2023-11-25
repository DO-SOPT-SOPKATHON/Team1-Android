package org.sopt.doSopkathon.presentation.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.doSopkathon.data.dataclass.List_DataClass
import org.sopt.doSopkathon.databinding.ItemListBinding

class ListAdapter(context: Context) : RecyclerView.Adapter<ListViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var listList: List<List_DataClass> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemListBinding.inflate(inflater, parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.onBind(listList[position])
    }

    override fun getItemCount()= listList.size

    fun setListList(listList: List<List_DataClass>) {
        this.listList = listList.toList()
        notifyDataSetChanged()
    }
}
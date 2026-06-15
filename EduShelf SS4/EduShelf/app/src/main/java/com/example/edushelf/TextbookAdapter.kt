package com.example.edushelf

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.edushelf.databinding.ItemTextbookBinding

class TextbookAdapter(
    private var items: List<Textbook>,
    private val onClick: (Textbook) -> Unit
) : RecyclerView.Adapter<TextbookAdapter.VH>() {

    inner class VH(val binding: ItemTextbookBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = DataBindingUtil.inflate<ItemTextbookBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_textbook,
            parent,
            false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val book = items[position]
        holder.binding.textbook = book
        holder.binding.executePendingBindings()
        holder.binding.btnMoreInfo.setOnClickListener { onClick(book) }
        holder.itemView.setOnClickListener { onClick(book) }
    }

    override fun getItemCount() = items.size

    fun updateList(newItems: List<Textbook>) {
        items = newItems
        notifyDataSetChanged()
    }
}
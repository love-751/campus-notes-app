package com.campusnotes.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.campusnotes.databinding.ItemUnitBinding
import com.campusnotes.model.Unit

class UnitListAdapter : ListAdapter<Unit, UnitListAdapter.UnitViewHolder>(UnitDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnitViewHolder {
        val binding = ItemUnitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UnitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UnitViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class UnitViewHolder(private val binding: ItemUnitBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(unit: Unit) {
            binding.unitName.text = unit.name
            binding.unitDescription.text = unit.description
        }
    }

    class UnitDiffCallback : DiffUtil.ItemCallback<Unit>() {
        override fun areItemsTheSame(oldItem: Unit, newItem: Unit) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Unit, newItem: Unit) =
            oldItem == newItem
    }
}

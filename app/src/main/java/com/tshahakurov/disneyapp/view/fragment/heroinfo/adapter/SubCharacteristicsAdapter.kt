package com.tshahakurov.disneyapp.view.fragment.heroinfo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tshahakurov.disneyapp.databinding.HeroCharacteristicItemBinding

class SubCharacteristicsAdapter : ListAdapter<String, SubCharacteristicsViewHolder>(
    object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String) = false
        override fun areContentsTheSame(oldItem: String, newItem: String) = false
    }
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubCharacteristicsViewHolder {
        return SubCharacteristicsViewHolder(
            HeroCharacteristicItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SubCharacteristicsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class SubCharacteristicsViewHolder(private val binding: HeroCharacteristicItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: String) {
        binding.characteristicItem.text = item
    }
}
package com.tshahakurov.disneyapp.view.fragment.heroinfo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tshahakurov.disneyapp.databinding.HeroCharacteristicHolderBinding
import com.tshahakurov.disneyapp.model.Hero

class CharacteristicsAdapter : ListAdapter<Hero.Characteristic, CharacteristicsViewHolder>
    (object : DiffUtil.ItemCallback<Hero.Characteristic>() {
    override fun areItemsTheSame(oldItem: Hero.Characteristic, newItem: Hero.Characteristic) = false
    override fun areContentsTheSame(oldItem: Hero.Characteristic, newItem: Hero.Characteristic) =
        false
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacteristicsViewHolder {
        return CharacteristicsViewHolder(
            HeroCharacteristicHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacteristicsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CharacteristicsViewHolder(private val binding: HeroCharacteristicHolderBinding) :
    ViewHolder(binding.root) {

    fun bind(heroCharacteristic: Hero.Characteristic) {
        with(binding) {
            if (heroCharacteristic.key.isNotBlank()) {
                binding.root.visibility = View.VISIBLE
                characteristicTitle.text = heroCharacteristic.key

                if (heroCharacteristic.value.isNotEmpty()) {
                    characteristicsItems.visibility = View.VISIBLE
                    characteristicsItems.run {
                        if (adapter == null) {
                            adapter = SubCharacteristicsAdapter()
                            layoutManager = LinearLayoutManager(
                                root.context,
                                RecyclerView.VERTICAL,
                                false
                            )
                        }
                        (adapter as? SubCharacteristicsAdapter)
                            ?.submitList(heroCharacteristic.value)
                    }
                } else {
                    characteristicTitle.visibility = View.GONE
                    characteristicsItems.visibility = View.GONE
                }
            } else {
                binding.root.visibility = View.GONE
            }
        }
    }
}
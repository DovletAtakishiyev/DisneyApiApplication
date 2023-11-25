package com.tshahakurov.disneyapp.view.fragment.allheroes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.tshahakurov.disneyapp.databinding.HeroItemBinding
import com.tshahakurov.disneyapp.model.Hero

class HeroesListAdapter(private val onClick: (Int) -> Unit) :
    ListAdapter<Hero, HeroViewHolder>(object : DiffUtil.ItemCallback<Hero>() {
        override fun areItemsTheSame(oldItem: Hero, newItem: Hero) = false
        override fun areContentsTheSame(oldItem: Hero, newItem: Hero) = false
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder(
            HeroItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }
}

class HeroViewHolder(private val binding: HeroItemBinding) : ViewHolder(binding.root) {

    fun bind(hero: Hero, onClick: (Int) -> Unit) {
        with(binding) {
            root.setOnClickListener {
                onClick(hero.id)
            }

            heroImage.run {
                Glide.with(root.context)
                    .load(hero.imageUrl)
                    .into(this)
            }

            heroName.text = hero.name
        }
    }
}
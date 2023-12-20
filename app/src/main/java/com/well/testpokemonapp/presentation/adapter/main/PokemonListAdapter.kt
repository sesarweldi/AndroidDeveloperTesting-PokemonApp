package com.well.testpokemonapp.presentation.adapter.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.well.testpokemonapp.R
import com.well.testpokemonapp.databinding.ItemPokemonBinding
import com.well.testpokemonapp.presentation.adapter.base.BaseAdapter
import com.well.testpokemonapp.presentation.listener.PokemonListener
import com.well.testpokemonapp.presentation.model.PokemonDataView

class PokemonListAdapter(private val listener: PokemonListener) :
    BaseAdapter<PokemonDataView, PokemonListAdapter.ViewHolder, ItemPokemonBinding>() {

    inner class ViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PokemonDataView) {
            binding.data = item
            binding.container.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }

    override fun getLayoutIdForType(viewType: Int): Int {
        return R.layout.item_pokemon
    }

    override fun bindViewHolder(holder: ViewHolder, item: PokemonDataView, position: Int) {
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, binding: ItemPokemonBinding): ViewHolder {
        return ViewHolder(binding)
    }
}
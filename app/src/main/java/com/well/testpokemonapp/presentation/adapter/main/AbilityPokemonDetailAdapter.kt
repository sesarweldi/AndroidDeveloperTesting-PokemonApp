package com.well.testpokemonapp.presentation.adapter.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.well.testpokemonapp.R
import com.well.testpokemonapp.databinding.ItemChipAbilityBinding
import com.well.testpokemonapp.presentation.adapter.base.BaseAdapter

class AbilityPokemonDetailAdapter :
    BaseAdapter<String, AbilityPokemonDetailAdapter.ViewHolder, ItemChipAbilityBinding>() {

    inner class ViewHolder(private val binding: ItemChipAbilityBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.content.text = item
        }
    }

    override fun getLayoutIdForType(viewType: Int): Int {
        return R.layout.item_chip_ability
    }

    override fun bindViewHolder(holder: ViewHolder, item: String, position: Int) {
        holder.bind(item)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        binding: ItemChipAbilityBinding
    ): ViewHolder {
        return ViewHolder(binding)
    }
}
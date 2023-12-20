package com.well.testpokemonapp.presentation.listener

import com.well.testpokemonapp.presentation.model.PokemonDataView


interface PokemonListener {
    fun onItemClicked(data: PokemonDataView)
}
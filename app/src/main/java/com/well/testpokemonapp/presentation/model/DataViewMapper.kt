package com.well.testpokemonapp.presentation.model

import com.well.testpokemonapp.domain.entity.PokemonEntity

object DataViewMapper {

    fun PokemonEntity.toListPokemonDataView(): List<PokemonDataView>? {
        return this.pokemonList?.map {
            PokemonDataView(it)
        }
    }
}
package com.well.testpokemonapp.presentation.model

import com.well.testpokemonapp.domain.entity.PokemonDetailEntity
import com.well.testpokemonapp.domain.entity.PokemonEntity

object DataViewMapper {

    fun PokemonEntity.toListPokemonDataView(): List<PokemonDataView>? {
        return this.pokemonList?.map {
            PokemonDataView(it)
        }
    }

    fun PokemonDetailEntity.toPokemonDetailDataView(): PokemonDetailDataView {
        return PokemonDetailDataView(
            name, picture, height, weight, abilities
        )
    }
}
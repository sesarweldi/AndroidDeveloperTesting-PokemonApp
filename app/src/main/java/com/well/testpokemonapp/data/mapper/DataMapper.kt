package com.well.testpokemonapp.data.mapper

import com.well.testpokemonapp.data.response.PokemonResponseModel
import com.well.testpokemonapp.domain.entity.PokemonEntity

object DataMapper {

    fun PokemonResponseModel.toPokemonEntity(): PokemonEntity {
        return PokemonEntity(
            pokemonList = this.results.map {
                it.name ?: ""
            }
        )
    }
}
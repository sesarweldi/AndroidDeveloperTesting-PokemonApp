package com.well.testpokemonapp.presentation.model

import com.well.testpokemonapp.domain.entity.PokemonDetailEntity
import com.well.testpokemonapp.domain.entity.PokemonEntity

object DataViewMapper {

    fun List<PokemonEntity>.toListPokemonDataView(): List<PokemonDataView> {
        return this.map {
            PokemonDataView(name = it.name)
        }
    }

    fun List<PokemonDataView>.toListPokemonEntity(): List<PokemonEntity> {
        return this.map {
            PokemonEntity(name = it.name ?: "")
        }
    }

    fun PokemonDetailEntity.toPokemonDetailDataView(): PokemonDetailDataView {
        return PokemonDetailDataView(
            name, picture, height, weight, abilities
        )
    }
}
package com.well.testpokemonapp.data.mapper

import com.well.testpokemonapp.data.response.PokemonDetailResponseModel
import com.well.testpokemonapp.data.response.PokemonResponseModel
import com.well.testpokemonapp.domain.entity.PokemonDetailEntity
import com.well.testpokemonapp.domain.entity.PokemonEntity

object DataMapper {

    fun PokemonResponseModel.toPokemonEntity(): List<PokemonEntity> {
        return results.map {
            PokemonEntity(name = it.name ?: "")
        }
    }

    fun PokemonDetailResponseModel.toPokemonDetailEntity(): PokemonDetailEntity {
        return PokemonDetailEntity(
            name = name,
            abilities = abilities.map { it.ability?.name ?: "" },
            picture = sprites?.frontDefault,
            weight = weight,
            height = height,
        )
    }
}
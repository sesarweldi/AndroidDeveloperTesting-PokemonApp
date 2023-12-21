package com.well.testpokemonapp.domain.repository

import com.well.testpokemonapp.domain.entity.PokemonDetailEntity
import com.well.testpokemonapp.domain.entity.PokemonEntity
import com.well.testpokemonapp.domain.params.GetPokemonDetailParam


interface Repository {

    suspend fun getPokemon(): PokemonEntity
    suspend fun getPokemonDetail(param: GetPokemonDetailParam): PokemonDetailEntity
}
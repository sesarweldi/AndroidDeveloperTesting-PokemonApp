package com.well.testpokemonapp.domain.repository

import com.well.testpokemonapp.domain.entity.PokemonEntity


interface Repository {

    suspend fun getPokemon(): PokemonEntity
}
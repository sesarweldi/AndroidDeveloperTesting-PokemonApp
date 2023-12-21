package com.well.testpokemonapp.domain.repository

import com.well.testpokemonapp.domain.entity.PokemonDetailEntity
import com.well.testpokemonapp.domain.entity.PokemonEntity
import com.well.testpokemonapp.domain.params.GetPokemonDetailParam
import com.well.testpokemonapp.presentation.model.PokemonDataView
import kotlinx.coroutines.flow.Flow


interface Repository {

    suspend fun getPokemon(): List<PokemonEntity>
    suspend fun getPokemonDetail(param: GetPokemonDetailParam): PokemonDetailEntity

    fun getLocalDataPokemon(): Flow<List<PokemonEntity>>

    suspend fun insertLocalDataPokemon(list: List<PokemonEntity>)
}
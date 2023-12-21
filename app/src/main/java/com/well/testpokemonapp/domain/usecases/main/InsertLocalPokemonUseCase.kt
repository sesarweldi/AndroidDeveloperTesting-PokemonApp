package com.well.testpokemonapp.domain.usecases.main

import com.well.testpokemonapp.domain.entity.PokemonEntity
import com.well.testpokemonapp.domain.repository.Repository
import javax.inject.Inject

class InsertLocalPokemonUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(list: List<PokemonEntity>) {
        repository.insertLocalDataPokemon(list)
    }
}
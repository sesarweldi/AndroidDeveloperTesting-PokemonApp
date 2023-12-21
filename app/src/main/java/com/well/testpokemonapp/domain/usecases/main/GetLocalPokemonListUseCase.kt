package com.well.testpokemonapp.domain.usecases.main

import com.well.testpokemonapp.domain.entity.PokemonEntity
import com.well.testpokemonapp.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocalPokemonListUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(): Flow<List<PokemonEntity>> {
        return repository.getLocalDataPokemon()
    }
}
package com.well.testpokemonapp.domain.usecases.main

import com.well.testpokemonapp.domain.entity.PokemonEntity
import com.well.testpokemonapp.domain.repository.Repository
import com.well.testpokemonapp.domain.usecases.base.NoParams
import com.well.testpokemonapp.domain.usecases.base.UseCase
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val repository: Repository
): UseCase<List<PokemonEntity>, NoParams>() {

    override suspend fun executeOnBackground(param: NoParams): List<PokemonEntity> {
        return repository.getPokemon()
    }

}
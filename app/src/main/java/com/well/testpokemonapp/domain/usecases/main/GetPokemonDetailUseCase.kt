package com.well.testpokemonapp.domain.usecases.main

import com.well.testpokemonapp.domain.entity.PokemonDetailEntity
import com.well.testpokemonapp.domain.params.GetPokemonDetailParam
import com.well.testpokemonapp.domain.repository.Repository
import com.well.testpokemonapp.domain.usecases.base.UseCase
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(
    private val repository: Repository
) : UseCase<PokemonDetailEntity, GetPokemonDetailParam>() {
    override suspend fun executeOnBackground(param: GetPokemonDetailParam): PokemonDetailEntity {
        return repository.getPokemonDetail(param)
    }
}
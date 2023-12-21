package com.well.testpokemonapp.data.repository

import com.well.testpokemonapp.data.datasource.PokemonNetworkDataSource
import com.well.testpokemonapp.data.mapper.DataMapper.toPokemonDetailEntity
import com.well.testpokemonapp.data.mapper.DataMapper.toPokemonEntity
import com.well.testpokemonapp.domain.entity.PokemonDetailEntity
import com.well.testpokemonapp.domain.entity.PokemonEntity
import com.well.testpokemonapp.domain.params.GetPokemonDetailParam
import com.well.testpokemonapp.domain.repository.Repository

class RepositoryImpl(private val dataSource: PokemonNetworkDataSource) : Repository {
    override suspend fun getPokemon(): PokemonEntity {
        return dataSource.getPokemon().toPokemonEntity()
    }

    override suspend fun getPokemonDetail(param: GetPokemonDetailParam): PokemonDetailEntity {
        return dataSource.getDetailPokemon(param.name).toPokemonDetailEntity()
    }

}
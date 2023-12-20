package com.well.testpokemonapp.data.repository

import com.well.testpokemonapp.data.datasource.PokemonNetworkDataSource
import com.well.testpokemonapp.data.mapper.DataMapper.toPokemonEntity
import com.well.testpokemonapp.domain.entity.PokemonEntity
import com.well.testpokemonapp.domain.repository.Repository

class RepositoryImpl(private val dataSource: PokemonNetworkDataSource) : Repository {
    override suspend fun getPokemon(): PokemonEntity {
        return dataSource.getPokemon().toPokemonEntity()
    }

}
package com.well.testpokemonapp.data.repository

import com.well.testpokemonapp.data.database.PokemonDao
import com.well.testpokemonapp.data.datasource.PokemonNetworkDataSource
import com.well.testpokemonapp.data.mapper.DataMapper.toPokemonDetailEntity
import com.well.testpokemonapp.data.mapper.DataMapper.toPokemonEntity
import com.well.testpokemonapp.domain.entity.PokemonDetailEntity
import com.well.testpokemonapp.domain.entity.PokemonEntity
import com.well.testpokemonapp.domain.params.GetPokemonDetailParam
import com.well.testpokemonapp.domain.repository.Repository
import com.well.testpokemonapp.presentation.model.PokemonDataView
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(private val dataSource: PokemonNetworkDataSource, private val database: PokemonDao) : Repository {
    override suspend fun getPokemon(): List<PokemonEntity> {
        return dataSource.getPokemon().toPokemonEntity()
    }

    override suspend fun getPokemonDetail(param: GetPokemonDetailParam): PokemonDetailEntity {
        return dataSource.getDetailPokemon(param.name).toPokemonDetailEntity()
    }

    override fun getLocalDataPokemon(): Flow<List<PokemonEntity>> {
        return database.getAllPokemon()
    }

    override suspend fun insertLocalDataPokemon(list: List<PokemonEntity>) {
        return database.insertAllPokemon(list)
    }

}
package com.well.testpokemonapp.di

import com.well.testpokemonapp.domain.repository.Repository
import com.well.testpokemonapp.domain.usecases.main.GetLocalPokemonListUseCase
import com.well.testpokemonapp.domain.usecases.main.GetPokemonDetailUseCase
import com.well.testpokemonapp.domain.usecases.main.GetPokemonUseCase
import com.well.testpokemonapp.domain.usecases.main.InsertLocalPokemonUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideUseCase(
        repository: Repository
    ): GetPokemonUseCase {
        return GetPokemonUseCase(repository)
    }

    @Provides
    fun provideDetailUseCase(repository: Repository): GetPokemonDetailUseCase {
        return GetPokemonDetailUseCase(repository)
    }

    @Provides
    fun provideGetPokemonListUseCase(repository: Repository): GetLocalPokemonListUseCase {
        return GetLocalPokemonListUseCase(repository)
    }

    @Provides
    fun provideInsertUserUseCase(repository: Repository): InsertLocalPokemonUseCase {
        return InsertLocalPokemonUseCase(repository)
    }
}
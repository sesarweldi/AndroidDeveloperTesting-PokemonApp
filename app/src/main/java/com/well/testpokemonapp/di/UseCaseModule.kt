package com.well.testpokemonapp.di

import com.well.testpokemonapp.domain.repository.Repository
import com.well.testpokemonapp.domain.usecases.main.GetPokemonUseCase
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
}
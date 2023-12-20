package com.well.testpokemonapp.di

import com.well.testpokemonapp.data.api.ApiHelper
import com.well.testpokemonapp.data.datasource.PokemonNetworkDataSource
import com.well.testpokemonapp.data.repository.RepositoryImpl
import com.well.testpokemonapp.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit() = ApiHelper.retrofitClient()

    @Provides
    fun provideNetworkDataSource(retrofit: Retrofit): PokemonNetworkDataSource =
        retrofit.create(PokemonNetworkDataSource::class.java)

    @Provides
    fun provideRepository(dataSource: PokemonNetworkDataSource): Repository {
        return RepositoryImpl(dataSource)
    }

}
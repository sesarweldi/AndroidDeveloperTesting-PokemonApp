package com.well.testpokemonapp.di

import android.content.Context
import androidx.room.Room
import com.well.testpokemonapp.data.DataConstant
import com.well.testpokemonapp.data.api.ApiHelper
import com.well.testpokemonapp.data.database.PokemonDao
import com.well.testpokemonapp.data.database.PokemonDatabase
import com.well.testpokemonapp.data.datasource.PokemonNetworkDataSource
import com.well.testpokemonapp.data.repository.RepositoryImpl
import com.well.testpokemonapp.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    @Singleton
    fun providePokemonDao(database: PokemonDatabase) : PokemonDao {
        return database.pokemonDao()
    }

    @Provides
    fun provideRepository(dataSource: PokemonNetworkDataSource, database: PokemonDao): Repository {
        return RepositoryImpl(dataSource,database)
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): PokemonDatabase {
        return Room.databaseBuilder(
            context, PokemonDatabase::class.java, DataConstant.POKEMON_DB
        ).build()
    }


}
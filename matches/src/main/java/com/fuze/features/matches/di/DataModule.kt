package com.fuze.features.matches.di

import android.content.Context
import android.content.SharedPreferences
import com.fuze.features.matches.data.remote.MatchApi
import com.fuze.features.matches.data.remote.PlayerApi
import com.fuze.features.matches.data.remote.repository.MatchesRepository
import com.fuze.features.matches.data.remote.repository.MatchesRepositoryImpl
import com.fuze.features.matches.data.remote.repository.PlayersRepository
import com.fuze.features.matches.data.remote.repository.PlayersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Qualifier

@Module(includes = [DatabaseModule::class, AbstractDataModule::class])
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    internal fun provideMatchApi(retrofit: Retrofit): MatchApi = retrofit.create(MatchApi::class.java)

    @Provides
    internal fun providePlayerApi(retrofit: Retrofit): PlayerApi = retrofit.create(PlayerApi::class.java)


    @Provides
    fun provideMatchesPreferences(context : Context): SharedPreferences = context.getSharedPreferences("matches", Context.MODE_PRIVATE)
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MatchesAnnotation


@Module
@InstallIn(SingletonComponent::class)
internal abstract class AbstractDataModule {
    @Binds
    abstract fun bindsMatchesRepository(implementation: MatchesRepositoryImpl): MatchesRepository
    @Binds
    abstract fun bindsPlayersRepository(implementation: PlayersRepositoryImpl): PlayersRepository
}

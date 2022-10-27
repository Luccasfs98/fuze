package com.fuze.features.matches.di

import android.content.Context
import androidx.room.Room
import com.fuze.features.matches.data.database.MatchesDatabase
import com.fuze.features.matches.data.database.dao.MatchDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object DatabaseModule {

    @Provides
    fun provideDatabase(context: Context): MatchesDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            MatchesDatabase::class.java, "matches_db"
        ).build()
    }

    @Provides
    fun provideContactEntityDao(database: MatchesDatabase): MatchDao = database.matchDao()
}
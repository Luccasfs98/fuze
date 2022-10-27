package com.fuze.core.di.modules

import com.fuze.core.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class BaseUrlModule {

    @Provides
    @Named("BASE_URL")
    fun provideBaseUrl() = BuildConfig.BASE_URL

}
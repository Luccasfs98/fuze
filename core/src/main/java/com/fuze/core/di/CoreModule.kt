package com.fuze.core.di

import com.fuze.core.di.factory.ViewModelFactoryModule
import com.fuze.core.di.modules.ContextModule
import com.fuze.core.di.modules.NetworkModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(
    includes = [
        NetworkModule::class,
        ViewModelFactoryModule::class,
        ContextModule::class
    ]
)
@InstallIn(SingletonComponent::class)
internal abstract class CoreModule

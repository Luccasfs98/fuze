package com.fuze.features.matches.di

import com.fuze.features.matches.domain.usecase.GetMatchesUseCase
import com.fuze.features.matches.domain.usecase.GetMatchesUseCaseImpl
import com.fuze.features.matches.domain.usecase.GetPlayersUseCase
import com.fuze.features.matches.domain.usecase.GetPlayersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class DomainModule {

    @Binds
    abstract fun provideGetMatchesUseCase(
        useCase : GetMatchesUseCaseImpl,
    ) : GetMatchesUseCase

    @Binds
    abstract fun provideGetPlayersByTeamIdUseCase(
        useCase : GetPlayersUseCaseImpl,
    ) : GetPlayersUseCase
}
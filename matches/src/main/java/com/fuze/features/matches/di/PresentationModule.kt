package com.fuze.features.matches.di

import androidx.lifecycle.ViewModel
import com.fuze.core.di.key.ViewModelKey
import com.fuze.features.matches.presentation.detail.MatchDetailViewModel
import com.fuze.features.matches.presentation.list.MatchesViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class PresentationModule {

      @Binds
      @IntoMap
      @ViewModelKey(MatchesViewModel::class)
      abstract fun provideMatchesViewModel(matchesViewModel: MatchesViewModel)
      : ViewModel

      @Binds
      @IntoMap
      @ViewModelKey(MatchDetailViewModel::class)
      abstract fun provideMatchDetailViewModel(matchesViewModel: MatchDetailViewModel)
              : ViewModel
}
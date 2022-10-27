package com.fuze.features.matches.presentation.detail

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fuze.core.data.exceptions.*
import com.fuze.features.matches.R
import com.fuze.features.matches.domain.model.PlayerModel
import com.fuze.features.matches.domain.usecase.GetPlayersUseCase
import com.fuze.features.matches.presentation.viewState.ViewState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

internal class MatchDetailViewModel @Inject constructor(
    private val getPlayersUseCase: GetPlayersUseCase,
    @Named("IO")
    private val ioDispatcher: CoroutineDispatcher,
    private val resources : Resources
    ) : ViewModel() {

    private val _list = MutableLiveData<List<PlayerModel>>()
    val list: LiveData<List<PlayerModel>>
        get() = _list

    private val _state = MutableLiveData<ViewState>()
    val stateList: LiveData<ViewState>
        get() = _state

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    fun fetchPlayers(matchId: Long) {
        viewModelScope.launch(ioDispatcher) {
            try{
                _state.postValue(ViewState.Loading)
                val list = getPlayersUseCase.invoke(matchId)
                if (list.isEmpty())
                    _state.postValue(ViewState.Empty)
                else {
                    _list.postValue(list)
                    _state.postValue(ViewState.Loaded)
                }
            } catch (exception : Exception){
                when(exception){
                    is InternetNotAvailableException -> {
                        _errorMessage.postValue(resources.getString(R.string.get_matches_error_internet_not_available))
                        _state.postValue(ViewState.Error)
                    }
                    is BadRequestException -> {
                        _errorMessage.postValue(exception.message.orEmpty())
                        _state.postValue(ViewState.Error)
                    }
                    is NotFoundException -> {
                        _errorMessage.postValue(resources.getString(R.string.not_found_error))
                        _state.postValue(ViewState.Error)
                    }
                    is UnauthorizedException -> {
                        _errorMessage.postValue(resources.getString(R.string.unauthorized_error))
                        _state.postValue(ViewState.Error)
                    }
                    is ServiceUnavailableException -> {
                        _errorMessage.postValue(resources.getString(R.string.service_unavailable_error))
                        _state.postValue(ViewState.Error)
                    }
                    else -> {
                        _errorMessage.postValue(resources.getString(R.string.unknown_error))
                        _state.postValue(ViewState.Error)
                    }
                }
            }
        }
    }
}
package com.fuze.features.matches.presentation.viewState

sealed class ViewState {

    object Loading : ViewState()
    object Refreshing : ViewState()
    object Empty : ViewState()
    object Loaded : ViewState()
    object Error : ViewState()

    fun isRefreshing() = this is Refreshing
    fun isLoaded() = this is Loaded
    fun isLoading() = this is Loading
    fun isEmpty() = this is Empty
    fun isError() = this is Error

}

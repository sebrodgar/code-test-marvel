package com.srg.pruebamarvel.presentation.common.flow

/**
 * Created by sebrodgar on 02/03/2021.
 */
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

sealed class LceStatus<C> {
    data class Content<C>(val content: C) : LceStatus<C>()
    data class Error<C>(val error: Throwable) : LceStatus<C>()
    data class Loading<C>(val isLoading: Boolean) : LceStatus<C>()
}

@ExperimentalCoroutinesApi
fun <T> lceFlow(block: suspend () -> T): Flow<LceStatus<T>> =
    flow {
        emit(block())
    }.lceFlow()


@ExperimentalCoroutinesApi
fun <T> Flow<T>.lceFlow(): Flow<LceStatus<T>> =
    this.map {
        LceStatus.Content(it) as LceStatus<T>
    }.catch {
        emit(LceStatus.Error(it))
    }.onStart {
        emit(LceStatus.Loading(true))
    }.onCompletion {
        emit(LceStatus.Loading(false))
    }


suspend fun <T> Flow<LceStatus<T>>.collect(
    onContent: (T) -> Unit,
    onError: (Throwable) -> Unit,
    onLoading: ((Boolean) -> Unit)? = null
) {
    this.collect {
        when (it) {
            is LceStatus.Error -> onError.invoke(it.error)
            is LceStatus.Content -> onContent.invoke(it.content)
            is LceStatus.Loading -> onLoading?.invoke(it.isLoading)
        }
    }
}
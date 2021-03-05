package com.srg.pruebamarvel.common.util

import com.srg.pruebamarvel.presentation.common.errors.DialogErrorViewEntity

/**
 * Created by sebrodgar on 04/03/2021.
 */
sealed class StateData<T> {
    data class Loading<T>(var loading: Boolean) : StateData<T>()
    data class Content<T>(var content: T) : StateData<T>()
    data class Error<T>(var error: DialogErrorViewEntity) : StateData<T>()
}
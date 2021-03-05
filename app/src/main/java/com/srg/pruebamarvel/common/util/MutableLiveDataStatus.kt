package com.srg.pruebamarvel.common.util

import androidx.lifecycle.MutableLiveData
import com.srg.pruebamarvel.presentation.common.errors.DialogErrorViewEntity

/**
 * Created by sebrodgar on 04/03/2021.
 */
class MutableLiveDataStatus<T> : MutableLiveData<StateData<T>>() {
    fun onLoading(loading: Boolean) = postValue(StateData.Loading(loading))
    fun onContent(content: T) = postValue(StateData.Content(content))
    fun onError(error: DialogErrorViewEntity) = postValue(StateData.Error(error))
}

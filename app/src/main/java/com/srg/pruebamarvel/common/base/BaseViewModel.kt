package com.srg.pruebamarvel.common.base

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.srg.pruebamarvel.common.util.SingleLiveEvent

/**
 * Created by sebrodgar on 27/02/2021.
 */
open class BaseViewModel : ViewModel() {
    @Suppress("MemberVisibilityCanBePrivate", "PropertyName")
    protected val navigation = SingleLiveEvent<NavDirections>()
}
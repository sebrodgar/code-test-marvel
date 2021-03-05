package com.srg.pruebamarvel.common.di.annotations

import androidx.fragment.app.Fragment
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by sebrodgar on 28/02/2021.
 */
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class FragmentKey(val value: KClass<out Fragment>)
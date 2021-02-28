package com.srg.pruebamarvel.common.di

import com.srg.pruebamarvel.MainActivityBuilder
import dagger.Module

/**
 * Created by sebrodgar on 28/02/2021.
 */
@Module(
    includes = [MainActivityBuilder::class]
)
class PresentationModule
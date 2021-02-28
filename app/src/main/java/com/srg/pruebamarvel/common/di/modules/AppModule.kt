package com.srg.pruebamarvel.common.di.modules

import android.content.Context
import com.srg.pruebamarvel.common.MarvelApplication
import dagger.Module
import dagger.Provides

/**
 * Created by sebrodgar on 26/02/2021.
 */
@Module
object AppModule {

    @Provides
    fun provideApplicationContext(application: MarvelApplication): Context =
        application.applicationContext
}
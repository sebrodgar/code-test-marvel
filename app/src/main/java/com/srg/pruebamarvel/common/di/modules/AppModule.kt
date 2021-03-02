package com.srg.pruebamarvel.common.di.modules

import android.content.Context
import com.srg.pruebamarvel.common.MarvelApplication
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Created by sebrodgar on 26/02/2021.
 */
@Module
object AppModule {

    @Provides
    fun provideApplicationContext(application: MarvelApplication): Context =
        application.applicationContext

    @Provides
    fun provideViewModelDispatcher(): CoroutineDispatcher = Dispatchers.Main
}
package com.srg.pruebamarvel.common.di.modules

import com.srg.pruebamarvel.data.MarvelApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by sebrodgar on 27/02/2021.
 */
@Module
object DataProvidersModule {

    @Provides
    fun provideCollectionsApiService(retrofit: Retrofit): MarvelApiService =
        retrofit.create(MarvelApiService::class.java)
}
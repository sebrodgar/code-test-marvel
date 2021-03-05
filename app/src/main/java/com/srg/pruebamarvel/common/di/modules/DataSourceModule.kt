package com.srg.pruebamarvel.common.di.modules

import com.srg.pruebamarvel.data.features.characters.sources.CharactersDataSource
import com.srg.pruebamarvel.data.features.characters.sources.CharactersRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

/**
 * Created by sebrodgar on 27/02/2021.
 */
@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindCharactersDataSource(dataSource: CharactersRemoteDataSourceImpl): CharactersDataSource
}
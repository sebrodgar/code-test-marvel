package com.srg.pruebamarvel.common.di.modules

import com.srg.pruebamarvel.data.features.characters.CharactersRepositoryImpl
import com.srg.pruebamarvel.domain.features.characters.CharactersRepository
import dagger.Binds
import dagger.Module

/**
 * Created by sebrodgar on 27/02/2021.
 */
@Module
abstract class RepositoriesModule {

    @Binds
    abstract fun bindCharacterRepository(repository: CharactersRepositoryImpl): CharactersRepository
}
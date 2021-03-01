package com.srg.pruebamarvel.data.features.characters

import com.srg.pruebamarvel.data.features.characters.sources.CharactersRemoteDataSourceImpl
import com.srg.pruebamarvel.domain.features.characters.CharactersRepository
import javax.inject.Inject

/**
 * Created by sebrodgar on 01/03/2021.
 */
class CharactersRepositoryImpl @Inject constructor(
    private val remote: CharactersRemoteDataSourceImpl
) : CharactersRepository {
}
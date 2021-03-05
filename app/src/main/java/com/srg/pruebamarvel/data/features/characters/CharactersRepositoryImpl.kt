package com.srg.pruebamarvel.data.features.characters

import com.srg.pruebamarvel.data.features.characters.mappers.toDomain
import com.srg.pruebamarvel.data.features.characters.sources.CharactersDataSource
import com.srg.pruebamarvel.domain.features.characters.CharactersRepository
import com.srg.pruebamarvel.domain.features.characters.models.CharacterDomainModel
import com.srg.pruebamarvel.domain.features.characters.models.CharactersPageDomainModel
import javax.inject.Inject

/**
 * Created by sebrodgar on 01/03/2021.
 */
class CharactersRepositoryImpl @Inject constructor(
    private val remote: CharactersDataSource
) : CharactersRepository {

    override suspend fun getCharacters(limit: Int, offset: Int): CharactersPageDomainModel =
        remote.getCharacters(limit, offset).toDomain()

    override suspend fun getCharacterItem(characterId: Long): CharacterDomainModel =
        remote.getCharacterItem(characterId).toDomain()
}
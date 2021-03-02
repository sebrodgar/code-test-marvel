package com.srg.pruebamarvel.data.features.characters

import com.srg.pruebamarvel.data.features.characters.mappers.toDomain
import com.srg.pruebamarvel.data.features.characters.sources.CharactersRemoteDataSourceImpl
import com.srg.pruebamarvel.domain.features.characters.CharactersRepository
import com.srg.pruebamarvel.domain.features.characters.models.CharacterDomainModel
import javax.inject.Inject

/**
 * Created by sebrodgar on 01/03/2021.
 */
class CharactersRepositoryImpl @Inject constructor(
    private val remote: CharactersRemoteDataSourceImpl
) : CharactersRepository {

    override suspend fun getCharacters(limit: Int, offset: Int): List<CharacterDomainModel> =
        remote.getCharacters(limit, offset).map { it.toDomain() }


    override suspend fun getCharacterItem(characterId: Long): CharacterDomainModel =
        remote.getCharacterItem(characterId).toDomain()

}
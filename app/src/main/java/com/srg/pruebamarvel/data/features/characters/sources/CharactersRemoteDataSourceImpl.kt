package com.srg.pruebamarvel.data.features.characters.sources

import com.srg.pruebamarvel.common.errors.toDomain
import com.srg.pruebamarvel.data.MarvelApiService
import com.srg.pruebamarvel.data.features.characters.models.CharacterApiModel
import javax.inject.Inject

/**
 * Created by sebrodgar on 01/03/2021.
 */
class CharactersRemoteDataSourceImpl @Inject constructor(
    private val marvelApiService: MarvelApiService
) : CharactersDataSource {

    override suspend fun getCharacters(limit: Int, offset: Int): List<CharacterApiModel> =
        try {
            marvelApiService.getCharacters(limit, offset).data.results
        } catch (e: Throwable) {
            throw e.toDomain()
        }

    override suspend fun getCharacterItem(characterId: Long): CharacterApiModel =
        try {
            marvelApiService.getCharacterItem(characterId).data.results[0]
        } catch (e: Throwable) {
            throw e.toDomain()
        }
}
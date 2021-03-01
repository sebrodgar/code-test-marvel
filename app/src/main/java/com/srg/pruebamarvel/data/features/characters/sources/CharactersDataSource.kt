package com.srg.pruebamarvel.data.features.characters.sources

import com.srg.pruebamarvel.data.features.characters.models.CharacterApiModel

/**
 * Created by sebrodgar on 01/03/2021.
 */
interface CharactersDataSource {
    suspend fun getCharacters(limit: Int, offset: Int): List<CharacterApiModel>
    suspend fun getCharacterItem(characterId: Long): CharacterApiModel
}
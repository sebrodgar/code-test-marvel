package com.srg.pruebamarvel.data.features.characters.sources

import com.srg.pruebamarvel.data.features.characters.models.CharacterApiModel
import com.srg.pruebamarvel.data.features.characters.models.CharactersPageApiModel

/**
 * Created by sebrodgar on 01/03/2021.
 */
interface CharactersDataSource {
    suspend fun getCharacters(limit: Int, offset: Int): CharactersPageApiModel?
    suspend fun getCharacterItem(characterId: Long): CharacterApiModel?
}
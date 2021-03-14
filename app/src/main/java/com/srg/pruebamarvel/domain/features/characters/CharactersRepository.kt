package com.srg.pruebamarvel.domain.features.characters

import com.srg.pruebamarvel.domain.features.characters.models.CharacterDomainModel
import com.srg.pruebamarvel.domain.features.characters.models.CharactersPageDomainModel

/**
 * Created by sebrodgar on 01/03/2021.
 */
interface CharactersRepository {
    suspend fun getCharacters(limit: Int, offset: Int): CharactersPageDomainModel?
    suspend fun getCharacterItem(characterId: Long): CharacterDomainModel?
}
package com.srg.pruebamarvel.domain.features.characters

import com.srg.pruebamarvel.domain.features.characters.models.CharacterDomainModel

/**
 * Created by sebrodgar on 01/03/2021.
 */
interface CharactersRepository {
    suspend fun getCharacters(limit: Int, offset: Int): List<CharacterDomainModel>
    suspend fun getCharacterItem(characterId: Long): CharacterDomainModel
}
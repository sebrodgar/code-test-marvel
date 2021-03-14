package com.srg.pruebamarvel.domain.features.characters

import com.srg.pruebamarvel.domain.features.characters.models.CharacterDomainModel
import com.srg.pruebamarvel.domain.flow.UseCase
import javax.inject.Inject

/**
 * Created by sebrodgar on 02/03/2021.
 */
class GetCharacterUseCase @Inject constructor(
    private val repository: CharactersRepository
) : UseCase<GetCharacterUseCase.Params, CharacterDomainModel?>() {

    data class Params(val characterId: Long)

    override suspend fun buildResult(params: Params): CharacterDomainModel? =
        repository.getCharacterItem(characterId = params.characterId)
}
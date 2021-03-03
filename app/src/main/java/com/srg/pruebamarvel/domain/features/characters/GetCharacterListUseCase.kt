package com.srg.pruebamarvel.domain.features.characters

import com.srg.pruebamarvel.domain.features.characters.models.CharacterDomainModel
import com.srg.pruebamarvel.domain.flow.UseCaseParamless
import javax.inject.Inject

/**
 * Created by sebrodgar on 02/03/2021.
 */
class GetCharacterListUseCase @Inject constructor(
    private val repository: CharactersRepository
) : UseCaseParamless<List<CharacterDomainModel>>() {
    companion object {
        const val RESULT_LIMITS = 20
    }

    private var offset = 0

    override suspend fun buildResult(): List<CharacterDomainModel> =
        repository.getCharacters(limit = RESULT_LIMITS, offset = offset)
}
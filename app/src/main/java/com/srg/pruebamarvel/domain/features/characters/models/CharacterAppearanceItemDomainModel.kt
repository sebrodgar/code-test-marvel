package com.srg.pruebamarvel.domain.features.characters.models

import com.srg.pruebamarvel.presentation.features.characters.details.appearances.models.CharacterAppearanceType

/**
 * Created by sebrodgar on 07/03/2021.
 */
data class CharacterAppearanceItemDomainModel(
    val appearanceType: CharacterAppearanceType,
    val resourceURI: String,
    val name: String,
    val type: String?
) {

}
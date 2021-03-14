package com.srg.pruebamarvel.domain.features.characters.models

import com.srg.pruebamarvel.presentation.features.characters.details.appearances.models.CharacterAppearanceType

/**
 * Created by sebrodgar on 07/03/2021.
 */
data class CharacterAppearanceDomainModel(
    val appearanceType: CharacterAppearanceType,
    val available: Int,
    val collectionURI: String,
    val appearances: List<CharacterAppearanceItemDomainModel>,
    val returned: Int
)
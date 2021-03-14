package com.srg.pruebamarvel.presentation.features.characters.mappers

import com.srg.pruebamarvel.common.extensions.marvelFormat
import com.srg.pruebamarvel.domain.features.characters.models.CharacterAppearanceDomainModel
import com.srg.pruebamarvel.domain.features.characters.models.CharacterAppearanceItemDomainModel
import com.srg.pruebamarvel.domain.features.characters.models.CharacterDomainModel
import com.srg.pruebamarvel.presentation.features.characters.details.appearances.models.CharacterAppearanceItemUiModel
import com.srg.pruebamarvel.presentation.features.characters.models.CharacterUiModel

/**
 * Created by sebrodgar on 04/03/2021.
 */

fun CharacterDomainModel.toUi() = CharacterUiModel(
    id = id,
    name = name,
    imageURL = "$thumbnailPath/landscape_xlarge.$thumbnailExtension",
    description = description,
    modifiedData = modifiedData?.marvelFormat(),
    resourceURI = resourceURI,
    appearances = appearances.toUi()
)

fun List<CharacterAppearanceDomainModel>.toUi(): List<CharacterAppearanceItemUiModel> =
    flatMap {
        it.appearances.map { appearanceItem ->
            appearanceItem.toUi()
        }
    }


fun CharacterAppearanceItemDomainModel.toUi() = CharacterAppearanceItemUiModel(
    appearanceType = appearanceType,
    resourceURI = resourceURI,
    name = name,
    type = type
)
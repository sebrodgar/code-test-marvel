package com.srg.pruebamarvel.presentation.features.characters.mappers

import com.srg.pruebamarvel.common.extensions.marvelFormat
import com.srg.pruebamarvel.domain.features.characters.models.CharacterDomainModel
import com.srg.pruebamarvel.presentation.features.characters.details.models.CharacterUiModel
import com.srg.pruebamarvel.presentation.features.characters.list.models.CharacterItemUiModel

/**
 * Created by sebrodgar on 04/03/2021.
 */

fun CharacterDomainModel.toItemUi() =
    CharacterItemUiModel(
        id,
        name,
        "$thumbnailPath/portrait_fantastic.$thumbnailExtension"
    )

fun CharacterDomainModel.toUi() = CharacterUiModel(
    id,
    name,
    "$thumbnailPath/landscape_xlarge.$thumbnailExtension",
    description,
    modifiedData.marvelFormat(),
    resourceURI
)

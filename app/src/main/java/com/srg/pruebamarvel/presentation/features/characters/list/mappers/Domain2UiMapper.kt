package com.srg.pruebamarvel.presentation.features.characters.list.mappers

import com.srg.pruebamarvel.domain.features.characters.models.CharacterDomainModel
import com.srg.pruebamarvel.presentation.features.characters.list.models.CharacterItemUiModel

/**
 * Created by sebrodgar on 04/03/2021.
 */

fun CharacterDomainModel.toUi() =
    CharacterItemUiModel(
        id,
        name,
        "$thumbnailPath/portrait_medium.$thumbnailExtension"
    )
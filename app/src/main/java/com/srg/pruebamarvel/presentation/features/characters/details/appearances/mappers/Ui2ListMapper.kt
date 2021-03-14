package com.srg.pruebamarvel.presentation.features.characters.details.appearances.mappers

import com.srg.pruebamarvel.presentation.features.characters.details.appearances.lists.CharacterAppearanceHeaderListItem
import com.srg.pruebamarvel.presentation.features.characters.details.appearances.lists.CharacterAppearanceListItem
import com.srg.pruebamarvel.presentation.features.characters.details.appearances.models.CharacterAppearanceItemUiModel
import com.srg.pruebamarvel.presentation.features.characters.details.appearances.models.CharacterAppearanceType

/**
 * Created by sebrodgar on 12/03/2021.
 */

fun List<CharacterAppearanceItemUiModel>.toCharactersListItems() =
    map { CharacterAppearanceListItem(it) }
        .groupBy {
            it.characterAppearance.appearanceType
        }
        .flatMap { entry ->
            listOf(
                entry.key.toListItem(),
                *entry.value.toTypedArray()
            )
        }

fun CharacterAppearanceType.toListItem(): CharacterAppearanceHeaderListItem =
    CharacterAppearanceHeaderListItem(name)
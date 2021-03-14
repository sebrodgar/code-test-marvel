package com.srg.pruebamarvel.presentation.features.characters.details.appearances

import com.srg.pruebamarvel.common.base.BaseViewModel
import com.srg.pruebamarvel.common.util.MutableLiveDataStatus
import com.srg.pruebamarvel.common.util.lists.ListItem
import com.srg.pruebamarvel.presentation.features.characters.details.appearances.lists.CharacterAppearanceListItem
import com.srg.pruebamarvel.presentation.features.characters.details.appearances.mappers.toListItem
import com.srg.pruebamarvel.presentation.features.characters.models.CharacterUiModel
import javax.inject.Inject


class CharacterDetailsAppearanceDialogViewModel @Inject constructor() : BaseViewModel() {

    private var _charactersAppearance = MutableLiveDataStatus<List<ListItem>>()
    val charactersAppearance = _charactersAppearance

    fun getCharacters(character: CharacterUiModel) {
        //_charactersAppearance.onContent(character.appearances.toCharactersListItems())
        val ch = charactersListItems(character)
        _charactersAppearance.onContent(ch)
    }

    private fun charactersListItems(character: CharacterUiModel) =
        character.appearances.map { CharacterAppearanceListItem(it) }
            .groupBy {
                it.characterAppearance.appearanceType
            }
            .flatMap { entry ->
                listOf(
                    entry.key.toListItem(),
                    *entry.value.toTypedArray()
                )
            }

}
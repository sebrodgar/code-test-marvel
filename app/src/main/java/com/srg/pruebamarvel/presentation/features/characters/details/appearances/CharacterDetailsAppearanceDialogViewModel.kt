package com.srg.pruebamarvel.presentation.features.characters.details.appearances

import com.srg.pruebamarvel.common.base.BaseViewModel
import com.srg.pruebamarvel.common.util.MutableLiveDataStatus
import com.srg.pruebamarvel.common.util.lists.ListItem
import com.srg.pruebamarvel.presentation.features.characters.details.appearances.mappers.toCharactersListItems
import com.srg.pruebamarvel.presentation.features.characters.models.CharacterUiModel
import javax.inject.Inject


class CharacterDetailsAppearanceDialogViewModel @Inject constructor() : BaseViewModel() {

    private var _charactersAppearance = MutableLiveDataStatus<List<ListItem>>()
    val charactersAppearance = _charactersAppearance

    fun getCharacters(character: CharacterUiModel) =
        _charactersAppearance.onContent(character.appearances.toCharactersListItems())
}
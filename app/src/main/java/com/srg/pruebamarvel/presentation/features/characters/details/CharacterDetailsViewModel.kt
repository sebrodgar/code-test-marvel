package com.srg.pruebamarvel.presentation.features.characters.details

import androidx.lifecycle.viewModelScope
import com.srg.pruebamarvel.common.base.BaseViewModel
import com.srg.pruebamarvel.common.errors.toDialogError
import com.srg.pruebamarvel.common.util.MutableLiveDataStatus
import com.srg.pruebamarvel.domain.features.characters.GetCharacterUseCase
import com.srg.pruebamarvel.presentation.common.flow.collect
import com.srg.pruebamarvel.presentation.common.flow.lceFlow
import com.srg.pruebamarvel.presentation.features.characters.mappers.toUi
import com.srg.pruebamarvel.presentation.features.characters.models.CharacterUiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CharacterDetailsViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
    private val dispatcher: CoroutineDispatcher
) : BaseViewModel() {

    private var _character = MutableLiveDataStatus<CharacterUiModel>()
    val character = _character

    fun getCharacter(characterId: Long) {
        viewModelScope.launch(dispatcher) {
            flow {
                emit(getCharacterUseCase.execute(GetCharacterUseCase.Params(characterId)))
            }
                .lceFlow()
                .collect(
                    onContent = { characterDomain ->
                        characterDomain?.let { _character.onContent(it.toUi()) }
                    },
                    onError = {
                        _character.onError(it.toDialogError())
                    },
                    onLoading = {
                        if (it) _character.onLoading(it)
                    }
                )
        }
    }
}
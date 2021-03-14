package com.srg.pruebamarvel.presentation.features.characters.list

import androidx.lifecycle.viewModelScope
import com.srg.pruebamarvel.common.base.BaseViewModel
import com.srg.pruebamarvel.common.errors.toDialogError
import com.srg.pruebamarvel.common.util.MutableLiveDataStatus
import com.srg.pruebamarvel.domain.features.characters.GetCharacterListUseCase
import com.srg.pruebamarvel.presentation.common.flow.collect
import com.srg.pruebamarvel.presentation.common.flow.lceFlow
import com.srg.pruebamarvel.presentation.features.characters.mappers.toUi
import com.srg.pruebamarvel.presentation.features.characters.models.CharacterUiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CharacterListViewModel @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase,
    private val dispatcher: CoroutineDispatcher
) : BaseViewModel() {

    private var _characters = MutableLiveDataStatus<List<CharacterUiModel>>()
    val characters = _characters

    fun getCharacters() {
        viewModelScope.launch(dispatcher) {
            lceFlow {
                getCharacterListUseCase.execute()
            }.collect(
                onContent = { charactersDomain ->
                    charactersDomain?.let { _characters.onContent(it.map { item -> item.toUi() }) }
                },
                onError = {
                    _characters.onError(it.toDialogError())
                },
                onLoading = {
                    if (it) _characters.onLoading(it)
                }
            )
        }
    }
}
package com.srg.pruebamarvel.presentation.features.characters.details

import androidx.lifecycle.viewModelScope
import com.srg.pruebamarvel.R
import com.srg.pruebamarvel.common.base.BaseViewModel
import com.srg.pruebamarvel.common.errors.APIErrorCode
import com.srg.pruebamarvel.common.errors.NetworkException
import com.srg.pruebamarvel.common.util.MutableLiveDataStatus
import com.srg.pruebamarvel.domain.features.characters.GetCharacterListUseCase
import com.srg.pruebamarvel.presentation.common.errors.DialogErrorViewEntity
import com.srg.pruebamarvel.presentation.common.flow.collect
import com.srg.pruebamarvel.presentation.common.flow.lceFlow
import com.srg.pruebamarvel.presentation.features.characters.list.mappers.toUi
import com.srg.pruebamarvel.presentation.features.characters.list.models.CharacterItemUiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CharacterDetailsViewModel @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase,
    private val dispatcher: CoroutineDispatcher
) : BaseViewModel() {

    private var _characters = MutableLiveDataStatus<List<CharacterItemUiModel>>()
    val characters = _characters

    fun getCharacters() {
        viewModelScope.launch(dispatcher) {
            flow { emit(getCharacterListUseCase.execute()) }
                .lceFlow()
                .collect(
                    onContent = {
                        _characters.onContent(it.map { item -> item.toUi() })
                    },
                    onError = {
                        when ((it as? NetworkException)?.marvelCode) {
                            APIErrorCode.CHARACTER_NOT_FOUND -> _characters.onError(
                                DialogErrorViewEntity(dialogMessage = R.string.error_dialog_character_not_found)
                            )

                            APIErrorCode.LIMIT_GREATER_THAN_100 -> _characters.onError(
                                DialogErrorViewEntity(dialogMessage = R.string.error_dialog_limit_greater_100)
                            )
                            APIErrorCode.LIMIT_INVALID_OR_BELOW_1 -> _characters.onError(
                                DialogErrorViewEntity(dialogMessage = R.string.error_dialog_limit_invalid_below_1)
                            )
                            APIErrorCode.INVALID_ORDERING -> _characters.onError(
                                DialogErrorViewEntity(dialogMessage = R.string.error_dialog_invalid_unrecognized)
                            )
                            APIErrorCode.EMPTY_PARAMETER -> _characters.onError(
                                DialogErrorViewEntity(dialogMessage = R.string.error_dialog_empty_parameter)
                            )
                            APIErrorCode.INVALID_REFERER -> _characters.onError(
                                DialogErrorViewEntity(dialogMessage = R.string.error_dialog_invalid_referer)
                            )


                            APIErrorCode.MISSING_API_KEY -> _characters.onError(
                                DialogErrorViewEntity(dialogMessage = R.string.error_dialog_missing_api_key)
                            )
                            APIErrorCode.MISSING_HASH -> _characters.onError(
                                DialogErrorViewEntity(
                                    dialogMessage = R.string.error_dialog_missing_hash
                                )
                            )
                            APIErrorCode.MISSING_TIMESTAMP -> _characters.onError(
                                DialogErrorViewEntity(dialogMessage = R.string.error_dialog_missing_timestamp)
                            )
                            APIErrorCode.METHOD_NOT_ALLOWED -> _characters.onError(
                                DialogErrorViewEntity(dialogMessage = R.string.error_dialog_method_not_allowed)
                            )
                            APIErrorCode.INVALID_REFERER -> _characters.onError(
                                DialogErrorViewEntity(dialogMessage = R.string.error_dialog_invalid_referer)
                            )
                            APIErrorCode.FORBIDDEN -> _characters.onError(
                                DialogErrorViewEntity(
                                    dialogMessage = R.string.error_dialog_forbidden
                                )
                            )
                            APIErrorCode.UNKNOWN -> _characters.onError(
                                DialogErrorViewEntity(
                                    dialogMessage = R.string.error_dialog_unknow
                                )
                            )
                            else -> _characters.onError(DialogErrorViewEntity(dialogMessage = R.string.error_dialog_unknow))
                        }
                    },
                    onLoading = {
                        if (it) _characters.onLoading(it)
                    }
                )
        }
    }
}
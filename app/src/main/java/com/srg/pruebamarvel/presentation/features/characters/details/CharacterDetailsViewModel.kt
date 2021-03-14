package com.srg.pruebamarvel.presentation.features.characters.details

import androidx.lifecycle.viewModelScope
import com.srg.pruebamarvel.R
import com.srg.pruebamarvel.common.base.BaseViewModel
import com.srg.pruebamarvel.common.errors.APIErrorCode
import com.srg.pruebamarvel.common.errors.NetworkException
import com.srg.pruebamarvel.common.util.MutableLiveDataStatus
import com.srg.pruebamarvel.domain.features.characters.GetCharacterUseCase
import com.srg.pruebamarvel.presentation.common.errors.DialogErrorViewEntity
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
                    onContent = {
                        _character.onContent(it.toUi())
                    },
                    onError = {
                        when ((it as? NetworkException)?.marvelCode) {
                            APIErrorCode.LIMIT_GREATER_THAN_100 -> _character.onError(
                                DialogErrorViewEntity(dialogMessage = R.string.error_dialog_limit_greater_100)
                            )
                            APIErrorCode.LIMIT_INVALID_OR_BELOW_1 -> _character.onError(
                                DialogErrorViewEntity(dialogMessage = R.string.error_dialog_limit_invalid_below_1)
                            )
                            APIErrorCode.INVALID_ORDERING -> _character.onError(
                                DialogErrorViewEntity(dialogMessage = R.string.error_dialog_invalid_unrecognized)
                            )
                            APIErrorCode.EMPTY_PARAMETER -> _character.onError(
                                DialogErrorViewEntity(dialogMessage = R.string.error_dialog_empty_parameter)
                            )
                            APIErrorCode.INVALID_REFERER -> _character.onError(
                                DialogErrorViewEntity(dialogMessage = R.string.error_dialog_invalid_referer)
                            )
                            APIErrorCode.MISSING_API_KEY -> _character.onError(
                                DialogErrorViewEntity(dialogMessage = R.string.error_dialog_missing_api_key)
                            )
                            APIErrorCode.MISSING_HASH -> _character.onError(
                                DialogErrorViewEntity(
                                    dialogMessage = R.string.error_dialog_missing_hash
                                )
                            )
                            APIErrorCode.MISSING_TIMESTAMP -> _character.onError(
                                DialogErrorViewEntity(dialogMessage = R.string.error_dialog_missing_timestamp)
                            )
                            APIErrorCode.METHOD_NOT_ALLOWED -> _character.onError(
                                DialogErrorViewEntity(dialogMessage = R.string.error_dialog_method_not_allowed)
                            )
                            APIErrorCode.FORBIDDEN -> _character.onError(
                                DialogErrorViewEntity(
                                    dialogMessage = R.string.error_dialog_forbidden
                                )
                            )
                            APIErrorCode.UNKNOWN -> _character.onError(
                                DialogErrorViewEntity(
                                    dialogMessage = R.string.error_dialog_unknow
                                )
                            )
                            else -> _character.onError(DialogErrorViewEntity(dialogMessage = R.string.error_dialog_unknow))
                        }
                    },
                    onLoading = {
                        if (it) _character.onLoading(it)
                    }
                )
        }
    }
}
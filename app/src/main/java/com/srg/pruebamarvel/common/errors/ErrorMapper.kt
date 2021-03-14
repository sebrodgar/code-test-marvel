package com.srg.pruebamarvel.common.errors

import com.srg.pruebamarvel.R
import com.srg.pruebamarvel.presentation.common.errors.DialogErrorViewEntity
import retrofit2.HttpException

/**
 * Created by sebrodgar on 01/03/2021.
 */
fun Throwable.toDomain() = when (this) {
    is HttpException -> {
        response()?.errorBody()?.string()?.run {
            try {
                parseHttpError<APIError>(this@toDomain.code(), this@run)
            } catch (e: Exception) {
                //ignore
                RuntimeException(this)
            }
        } ?: NetworkException(code(), APIErrorCode.UNKNOWN)
    }
    else -> this
}

fun Throwable.toDialogError(): DialogErrorViewEntity =
    when ((this as? NetworkException)?.marvelCode) {
        APIErrorCode.LIMIT_GREATER_THAN_100 ->
            DialogErrorViewEntity(dialogMessage = R.string.error_dialog_limit_greater_100)
        APIErrorCode.LIMIT_INVALID_OR_BELOW_1 ->
            DialogErrorViewEntity(dialogMessage = R.string.error_dialog_limit_invalid_below_1)

        APIErrorCode.INVALID_ORDERING ->
            DialogErrorViewEntity(dialogMessage = R.string.error_dialog_invalid_unrecognized)

        APIErrorCode.EMPTY_PARAMETER ->
            DialogErrorViewEntity(dialogMessage = R.string.error_dialog_empty_parameter)

        APIErrorCode.INVALID_REFERER ->
            DialogErrorViewEntity(dialogMessage = R.string.error_dialog_invalid_referer)

        APIErrorCode.MISSING_API_KEY ->
            DialogErrorViewEntity(dialogMessage = R.string.error_dialog_missing_api_key)

        APIErrorCode.MISSING_HASH ->
            DialogErrorViewEntity(
                dialogMessage = R.string.error_dialog_missing_hash
            )
        APIErrorCode.MISSING_TIMESTAMP ->
            DialogErrorViewEntity(dialogMessage = R.string.error_dialog_missing_timestamp)

        APIErrorCode.METHOD_NOT_ALLOWED ->
            DialogErrorViewEntity(dialogMessage = R.string.error_dialog_method_not_allowed)

        APIErrorCode.FORBIDDEN ->
            DialogErrorViewEntity(
                dialogMessage = R.string.error_dialog_forbidden
            )

        APIErrorCode.UNKNOWN ->
            DialogErrorViewEntity(
                dialogMessage = R.string.error_dialog_unknow
            )

        else -> DialogErrorViewEntity(dialogMessage = R.string.error_dialog_unknow)
    }

package com.srg.pruebamarvel.common.errors

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

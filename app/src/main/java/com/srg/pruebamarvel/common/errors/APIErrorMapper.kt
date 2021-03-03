package com.srg.pruebamarvel.common.errors

import com.google.gson.GsonBuilder
import com.srg.pruebamarvel.common.util.fromEnum

/**
 * Created by sebrodgar on 01/03/2021.
 */
inline fun <reified T> parseHttpError(httpCode: Int, errorBody: String) =
    GsonBuilder().create().getAdapter(APIError::class.java).fromJson(
        errorBody
    ).run {
        NetworkException(
            httpCode,
            fromEnum(this?.code, APIErrorCode.UNKNOWN)
        )
    }

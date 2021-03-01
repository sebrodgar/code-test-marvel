package com.srg.pruebamarvel.common.errors

/**
 * Created by sebrodgar on 01/03/2021.
 */
@Suppress("MemberVisibilityCanBePrivate")
class NetworkException(
    val code: Int, val cbCode: APIErrorCode, val cbMessage: String?
) : RuntimeException("HTTP error code $code; cbCode: $cbCode; apiMessage: $cbMessage")
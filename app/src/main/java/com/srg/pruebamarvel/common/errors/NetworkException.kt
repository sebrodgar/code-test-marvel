package com.srg.pruebamarvel.common.errors

/**
 * Created by sebrodgar on 01/03/2021.
 */
@Suppress("MemberVisibilityCanBePrivate")
class NetworkException(
    code: Int, marvelCode: APIErrorCode
) : RuntimeException("HTTP error code $code; Code: $marvelCode")
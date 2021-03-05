package com.srg.pruebamarvel.domain.flow

/**
 * Created by sebrodgar on 02/03/2021.
 */
abstract class UseCaseParamless<Output> {
    suspend fun execute(): Output = buildResult()

    protected abstract suspend fun buildResult(): Output
}
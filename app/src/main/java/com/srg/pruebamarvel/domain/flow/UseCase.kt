package com.srg.pruebamarvel.domain.flow

/**
 * Created by sebrodgar on 02/03/2021.
 */
abstract class UseCase<in Params, Output> {
    suspend fun execute(params: Params): Output = buildResult(params)

    protected abstract suspend fun buildResult(params: Params): Output
}
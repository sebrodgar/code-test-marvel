package com.srg.pruebamarvel.utils

import com.srg.pruebamarvel.data.features.characters.models.MarvelResponseApiModel
import kotlin.random.Random

/**
 * Created by sebrodgar on 05/03/2021.
 */
object MarvelResponseApiModelFactory {
    fun createOne() = MarvelResponseApiModel(
        code = Random.nextInt(),
        status = Random.nextString(),
        data = CharactersPageApiModelFactory.createOne()
    )
}
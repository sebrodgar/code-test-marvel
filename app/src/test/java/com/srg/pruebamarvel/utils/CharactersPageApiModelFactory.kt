package com.srg.pruebamarvel.utils

import com.srg.pruebamarvel.data.features.characters.models.CharactersPageApiModel
import kotlin.random.Random

/**
 * Created by sebrodgar on 05/03/2021.
 */
object CharactersPageApiModelFactory {
    fun createOne() = CharactersPageApiModel(
        offset = Random.nextInt(),
        limit = Random.nextInt(),
        total = Random.nextInt(),
        count = Random.nextInt(),
        results = listOf(
            CharacterApiModelFactory.createOne()
        )
    )
}
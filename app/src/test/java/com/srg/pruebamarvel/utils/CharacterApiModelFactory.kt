package com.srg.pruebamarvel.utils

import com.srg.pruebamarvel.data.features.characters.models.CharacterApiModel
import com.srg.pruebamarvel.data.features.characters.models.ThumbnailApiModel
import java.time.LocalDateTime
import kotlin.random.Random

/**
 * Created by sebrodgar on 05/03/2021.
 */
object CharacterApiModelFactory {
    fun createOne(): CharacterApiModel =
        CharacterApiModel(
            id = 0,
            name = Random.nextString(),
            description = Random.nextString(),
            modifiedData = LocalDateTime.now(),
            thumbnail = ThumbnailApiModel(Random.nextString(), Random.nextString()),
            resourceURI = Random.nextString()
        )
}
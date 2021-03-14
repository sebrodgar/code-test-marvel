package com.srg.pruebamarvel.data.features.characters.models

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

/**
 * Created by sebrodgar on 01/03/2021.
 */
data class CharacterApiModel(
    val id: Long,
    val name: String,
    val description: String,
    @SerializedName("modified")
    val modifiedData: LocalDateTime,
    val thumbnail: ThumbnailApiModel,
    val resourceURI: String,
    val series: CharacterAppearanceApiModel,
    val stories: CharacterAppearanceApiModel,
    val comics: CharacterAppearanceApiModel,
    val events: CharacterAppearanceApiModel
)
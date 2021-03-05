package com.srg.pruebamarvel.presentation.features.characters.details.models

/**
 * Created by sebrodgar on 03/03/2021.
 */
data class CharacterUiModel(
    val id: Long,
    val name: String,
    val imageURL: String,
    val description: String,
    val modifiedData: String,
    val resourceURI: String
)
package com.srg.pruebamarvel.data.features.characters.models

/**
 * Created by sebrodgar on 07/03/2021.
 */
data class CharacterAppearanceApiModel(
    val available: Int,
    val collectionURI: String,
    val items: List<CharacterAppearanceItemApiModel>,
    val returned: Int
)
package com.srg.pruebamarvel.data.features.characters.models

/**
 * Created by sebrodgar on 01/03/2021.
 */
data class CharactersPageApiModel(
    val offset: Int?,
    val limit: Int?,
    val total: Int?,
    val count: Int?,
    val results: List<CharacterApiModel>?
)

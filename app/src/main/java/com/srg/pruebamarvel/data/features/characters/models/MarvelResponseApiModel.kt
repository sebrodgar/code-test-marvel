package com.srg.pruebamarvel.data.features.characters.models

/**
 * Created by sebrodgar on 01/03/2021.
 */
data class MarvelResponseApiModel(
    val code: Int,
    val status: String,
    val data: CharactersPageApiModel
)

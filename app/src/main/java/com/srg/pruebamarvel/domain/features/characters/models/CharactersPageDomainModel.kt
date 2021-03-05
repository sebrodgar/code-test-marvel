package com.srg.pruebamarvel.domain.features.characters.models

/**
 * Created by sebrodgar on 01/03/2021.
 */
data class CharactersPageDomainModel(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<CharacterDomainModel>
)

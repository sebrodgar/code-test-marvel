package com.srg.pruebamarvel.domain.features.characters.models

import java.time.LocalDateTime

/**
 * Created by sebrodgar on 01/03/2021.
 */
data class CharacterDomainModel(
    val id: Long?,
    val name: String?,
    val description: String?,
    val modifiedData: LocalDateTime?,
    val thumbnailPath: String?,
    val thumbnailExtension: String?,
    val resourceURI: String?,
    val appearances: List<CharacterAppearanceDomainModel>
)
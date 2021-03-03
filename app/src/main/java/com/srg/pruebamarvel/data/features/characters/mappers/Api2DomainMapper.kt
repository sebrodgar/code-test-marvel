package com.srg.pruebamarvel.data.features.characters.mappers

import com.srg.pruebamarvel.data.features.characters.models.CharacterApiModel
import com.srg.pruebamarvel.domain.features.characters.models.CharacterDomainModel

/**
 * Created by sebrodgar on 02/03/2021.
 */

fun CharacterApiModel.toDomain(): CharacterDomainModel = CharacterDomainModel(
    id = id,
    name = name,
    description = description,
    modifiedData = modifiedData,
    thumbnailPath = thumbnail.path,
    thumbnailExtension = thumbnail.extension,
    resourceURI = resourceURI
)
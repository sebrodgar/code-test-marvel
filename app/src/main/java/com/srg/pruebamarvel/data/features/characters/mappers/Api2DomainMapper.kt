package com.srg.pruebamarvel.data.features.characters.mappers

import com.srg.pruebamarvel.data.features.characters.models.CharacterApiModel
import com.srg.pruebamarvel.data.features.characters.models.CharactersPageApiModel
import com.srg.pruebamarvel.domain.features.characters.models.CharacterDomainModel
import com.srg.pruebamarvel.domain.features.characters.models.CharactersPageDomainModel

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

fun CharactersPageApiModel.toDomain(): CharactersPageDomainModel = CharactersPageDomainModel(
    offset = offset,
    limit = limit,
    total = total,
    count = count,
    results = results.map { it.toDomain() }
)

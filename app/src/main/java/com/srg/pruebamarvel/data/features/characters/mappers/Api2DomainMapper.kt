package com.srg.pruebamarvel.data.features.characters.mappers

import com.srg.pruebamarvel.data.features.characters.models.CharacterApiModel
import com.srg.pruebamarvel.data.features.characters.models.CharacterAppearanceApiModel
import com.srg.pruebamarvel.data.features.characters.models.CharacterAppearanceItemApiModel
import com.srg.pruebamarvel.data.features.characters.models.CharactersPageApiModel
import com.srg.pruebamarvel.domain.features.characters.models.CharacterAppearanceDomainModel
import com.srg.pruebamarvel.domain.features.characters.models.CharacterAppearanceItemDomainModel
import com.srg.pruebamarvel.domain.features.characters.models.CharacterDomainModel
import com.srg.pruebamarvel.domain.features.characters.models.CharactersPageDomainModel
import com.srg.pruebamarvel.presentation.features.characters.details.appearances.models.CharacterAppearanceType

/**
 * Created by sebrodgar on 02/03/2021.
 */

fun CharacterApiModel.toDomain(): CharacterDomainModel = CharacterDomainModel(
    id = id,
    name = name,
    description = description,
    modifiedData = modifiedData,
    thumbnailPath = thumbnail?.path,
    thumbnailExtension = thumbnail?.extension,
    resourceURI = resourceURI,
    appearances = getAppearances(series, stories, comics, events)
)

fun CharactersPageApiModel.toDomain(): CharactersPageDomainModel = CharactersPageDomainModel(
    offset = offset,
    limit = limit,
    total = total,
    count = count,
    results = results?.map { it.toDomain() }
)

fun CharacterAppearanceItemApiModel.toDomain(characterAppearanceType: CharacterAppearanceType): CharacterAppearanceItemDomainModel =
    CharacterAppearanceItemDomainModel(
        resourceURI = resourceURI,
        name = name,
        type = type,
        appearanceType = characterAppearanceType
    )

fun CharacterAppearanceApiModel.toDomain(characterAppearanceType: CharacterAppearanceType): CharacterAppearanceDomainModel =
    CharacterAppearanceDomainModel(
        appearanceType = characterAppearanceType,
        available = available,
        collectionURI = collectionURI,
        appearances = getAppearancesItem(items, characterAppearanceType),
        returned = returned
    )

private fun getAppearances(
    series: CharacterAppearanceApiModel?,
    stories: CharacterAppearanceApiModel?,
    comics: CharacterAppearanceApiModel?,
    events: CharacterAppearanceApiModel?
): List<CharacterAppearanceDomainModel> {
    val appearances = emptyList<CharacterAppearanceDomainModel>().toMutableList()
    series?.let { appearances.add(it.toDomain(CharacterAppearanceType.SERIES)) }
    stories?.let { appearances.add(it.toDomain(CharacterAppearanceType.STORIES)) }
    comics?.let { appearances.add(it.toDomain(CharacterAppearanceType.COMICS)) }
    events?.let { appearances.add(it.toDomain(CharacterAppearanceType.EVENTS)) }
    return appearances
}

private fun getAppearancesItem(
    appearancesApi: List<CharacterAppearanceItemApiModel>?,
    characterAppearanceType: CharacterAppearanceType
): List<CharacterAppearanceItemDomainModel> {
    val appearances = emptyList<CharacterAppearanceItemDomainModel>().toMutableList()
    appearancesApi?.let {
        appearances.addAll(it.map { appearanceItem ->
            appearanceItem.toDomain(
                characterAppearanceType
            )
        })
    }
    return appearances
}

package com.srg.pruebamarvel.presentation.features.characters.details.appearances.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by sebrodgar on 03/03/2021.
 */
@Parcelize
data class CharacterAppearanceItemUiModel(
    val appearanceType: CharacterAppearanceType,
    val resourceURI: String?,
    val name: String?,
    val type: String?
) : Parcelable
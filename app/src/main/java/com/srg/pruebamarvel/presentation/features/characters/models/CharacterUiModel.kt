package com.srg.pruebamarvel.presentation.features.characters.models

import android.os.Parcelable
import com.srg.pruebamarvel.presentation.features.characters.details.appearances.models.CharacterAppearanceItemUiModel
import kotlinx.android.parcel.Parcelize

/**
 * Created by sebrodgar on 03/03/2021.
 */
@Parcelize
data class CharacterUiModel(
    val id: Long,
    val name: String,
    val imageURL: String,
    val description: String,
    val modifiedData: String,
    val resourceURI: String,
    val appearances: List<CharacterAppearanceItemUiModel>
) : Parcelable
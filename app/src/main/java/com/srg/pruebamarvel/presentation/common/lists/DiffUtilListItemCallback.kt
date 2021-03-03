package com.srg.pruebamarvel.presentation.common.lists

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.srg.pruebamarvel.presentation.features.characters.list.models.CharacterItemUiModel

object DiffUtilListItemCallback : DiffUtil.ItemCallback<CharacterItemUiModel>() {

    override fun areItemsTheSame(
        oldItem: CharacterItemUiModel,
        newItem: CharacterItemUiModel
    ): Boolean =
        oldItem.id == newItem.id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: CharacterItemUiModel,
        newItem: CharacterItemUiModel
    ): Boolean =
        oldItem == newItem

}
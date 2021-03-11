package com.srg.pruebamarvel.presentation.features.characters.details.appearances.lists

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.srg.pruebamarvel.common.util.lists.ListItem

/**
 * Created by sebrodgar on 12/03/2021.
 */
object DiffUtilListItemCallback : DiffUtil.ItemCallback<ListItem>() {

    override fun areItemsTheSame(
        oldItem: ListItem,
        newItem: ListItem
    ): Boolean =
        oldItem.itemId == newItem.itemId

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: ListItem,
        newItem: ListItem
    ): Boolean =
        oldItem == newItem

}
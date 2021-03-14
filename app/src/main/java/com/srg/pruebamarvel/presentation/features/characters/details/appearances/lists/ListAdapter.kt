package com.srg.pruebamarvel.presentation.features.characters.details.appearances.lists

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.srg.pruebamarvel.common.util.lists.ListItem
import com.srg.pruebamarvel.common.util.lists.ListViewHolder


/**
 * Created by sebrodgar on 12/03/2021.
 */
class ListAdapter(
    callback: DiffUtil.ItemCallback<ListItem> = DiffUtilListItemCallback,
    private val onItemClickListener: ((ListItem) -> Unit)? = null
) : ListAdapter<ListItem, ListViewHolder>(callback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) =
        getItem(position).bind(holder, onItemClickListener)

    override fun getItemViewType(position: Int) =
        getItem(position).layoutId

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

}
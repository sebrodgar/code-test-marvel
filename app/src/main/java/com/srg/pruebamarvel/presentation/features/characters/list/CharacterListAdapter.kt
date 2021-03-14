package com.srg.pruebamarvel.presentation.features.characters.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.srg.pruebamarvel.R
import com.srg.pruebamarvel.presentation.common.listeners.OnBottomReachedListener
import com.srg.pruebamarvel.presentation.common.listeners.OnItemClickListener
import com.srg.pruebamarvel.presentation.features.characters.models.CharacterUiModel
import kotlinx.android.synthetic.main.list_item_character.view.*


class CharacterListAdapter(
    private val listener: OnItemClickListener<CharacterUiModel>,
    private val onBottomReachedListener: OnBottomReachedListener
) : ListAdapter<CharacterUiModel, RecyclerView.ViewHolder>(DiffUtilListItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharacterViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item_character, parent, false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as CharacterViewHolder).bind(item)
        holder.itemView.setOnClickListener { listener.onItemClick(item) }
        if (position == (itemCount - 1)) {
            onBottomReachedListener.onBottomReached(position)
        }
    }

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("DefaultLocale")
        fun bind(item: CharacterUiModel) {
            itemView.tv_character_name.text = item.name
            Glide.with(itemView.context).load(item.imageURL)
                .placeholder(R.drawable.marvel_placeholder)
                .into(itemView.iv_character_image)

        }
    }

    object DiffUtilListItemCallback : DiffUtil.ItemCallback<CharacterUiModel>() {

        override fun areItemsTheSame(
            oldItem: CharacterUiModel,
            newItem: CharacterUiModel
        ): Boolean =
            oldItem.id == newItem.id

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: CharacterUiModel,
            newItem: CharacterUiModel
        ): Boolean =
            oldItem == newItem

    }
}


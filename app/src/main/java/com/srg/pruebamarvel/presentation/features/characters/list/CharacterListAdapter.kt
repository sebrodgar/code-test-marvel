package com.srg.pruebamarvel.presentation.features.characters.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.srg.pruebamarvel.R
import com.srg.pruebamarvel.presentation.common.listeners.OnBottomReachedListener
import com.srg.pruebamarvel.presentation.common.listeners.OnItemClickListener
import com.srg.pruebamarvel.presentation.common.lists.DiffUtilListItemCallback
import com.srg.pruebamarvel.presentation.features.characters.list.models.CharacterItemUiModel
import kotlinx.android.synthetic.main.character_item.view.*


class CharacterListAdapter(
    private val listener: OnItemClickListener<CharacterItemUiModel>,
    private val onBottomReachedListener: OnBottomReachedListener
) : ListAdapter<CharacterItemUiModel, RecyclerView.ViewHolder>(DiffUtilListItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharacterViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
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
        fun bind(item: CharacterItemUiModel) {
            itemView.tv_character_name.text = item.name
            Glide.with(itemView.context).load(item.imageURL).into(itemView.iv_character_image)

        }
    }
}
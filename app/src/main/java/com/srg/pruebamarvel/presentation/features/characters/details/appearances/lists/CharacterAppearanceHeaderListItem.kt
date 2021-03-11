package com.srg.pruebamarvel.presentation.features.characters.details.appearances.lists

import com.srg.pruebamarvel.R
import com.srg.pruebamarvel.common.util.lists.ListItem
import com.srg.pruebamarvel.common.util.lists.ListViewHolder
import com.srg.pruebamarvel.databinding.ListItemCharacterHeaderBinding

/**
 * Created by sebrodgar on 12/03/2021.
 */
class CharacterAppearanceHeaderListItem(
    private val titleRes: String
) : ListItem(
    R.layout.list_item_character_header,
    titleRes
) {

    private var _binding: ListItemCharacterHeaderBinding? = null
    private val binding: ListItemCharacterHeaderBinding get() = _binding!!

    override fun bind(
        viewHolder: ListViewHolder,
        onClickListener: ((ListItem) -> Unit)?
    ) {
        _binding = ListItemCharacterHeaderBinding.bind(viewHolder.containerView)
        binding.headerCollection.text = titleRes
    }
}
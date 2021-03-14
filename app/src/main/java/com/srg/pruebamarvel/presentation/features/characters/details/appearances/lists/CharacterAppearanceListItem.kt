package com.srg.pruebamarvel.presentation.features.characters.details.appearances.lists

import com.srg.pruebamarvel.R
import com.srg.pruebamarvel.common.util.lists.ListItem
import com.srg.pruebamarvel.common.util.lists.ListViewHolder
import com.srg.pruebamarvel.databinding.ListItemAppearanceBinding
import com.srg.pruebamarvel.presentation.features.characters.details.appearances.models.CharacterAppearanceItemUiModel

/**
 * Created by sebrodgar on 12/03/2021.
 */
class CharacterAppearanceListItem(
    val characterAppearance: CharacterAppearanceItemUiModel
) : ListItem(
    R.layout.list_item_appearance,
    characterAppearance
) {

    private var _binding: ListItemAppearanceBinding? = null
    private val binding: ListItemAppearanceBinding get() = _binding!!

    override fun bind(
        viewHolder: ListViewHolder,
        onClickListener: ((ListItem) -> Unit)?
    ) {
        super.bind(viewHolder, onClickListener)
        _binding = ListItemAppearanceBinding.bind(viewHolder.containerView)
        binding.tvAppearanceName.text = characterAppearance.name
    }
}
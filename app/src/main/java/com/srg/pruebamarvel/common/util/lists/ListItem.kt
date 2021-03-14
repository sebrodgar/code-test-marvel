package com.srg.pruebamarvel.common.util.lists

import android.content.Context
import android.content.res.Resources
import androidx.annotation.LayoutRes

/**
 * Created by sebrodgar on 12/03/2021.
 */
abstract class ListItem(
    @LayoutRes
    val layoutId: Int,
    val itemId: Any
) {

    lateinit var context: Context
    val resources: Resources get() = context.resources

    open fun bind(
        viewHolder: ListViewHolder,
        onClickListener: ((T: ListItem) -> Unit)? = null
    ) {
        context = viewHolder.containerView.context
    }
}
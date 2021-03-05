package com.srg.pruebamarvel.presentation.common.errors

import androidx.annotation.StringRes
import com.srg.pruebamarvel.R

class DialogErrorViewEntity(
    @StringRes val dialogMessage: Int = -1,
    @StringRes val positiveButton: Int = android.R.string.ok,
    @StringRes val dialogTitle: Int = R.string.error_dialog_title,
    @StringRes val negativeButton: Int = android.R.string.cancel,
    val varStrings: Array<String?> = arrayOf()
)
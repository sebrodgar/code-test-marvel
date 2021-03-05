package com.srg.pruebamarvel.presentation.common.extensions

import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.srg.pruebamarvel.presentation.common.errors.DialogErrorViewEntity

/**
 * Created by sebrodgar on 05/03/2021.
 */

fun Fragment.setUpToolbar(toolbar: Toolbar) {
    val navController = findNavController()
    val appBarConfiguration = AppBarConfiguration(navController.graph)
    toolbar.setupWithNavController(navController, appBarConfiguration)
}

fun Fragment.showError(
    context: Context,
    dialogErrorViewEntity: DialogErrorViewEntity,
    onPositiveButtonPressed: () -> Unit = {}
): AlertDialog =
    MaterialAlertDialogBuilder(context)
        .setCancelable(false)
        .setTitle(dialogErrorViewEntity.dialogTitle)
        .setMessage(dialogErrorViewEntity.dialogMessage)
        .setPositiveButton(dialogErrorViewEntity.positiveButton) { _, _ ->
            onPositiveButtonPressed()
        }
        .show()
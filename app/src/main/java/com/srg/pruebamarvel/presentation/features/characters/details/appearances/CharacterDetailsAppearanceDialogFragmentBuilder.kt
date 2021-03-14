package com.srg.pruebamarvel.presentation.features.characters.details.appearances

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.srg.pruebamarvel.common.di.annotations.FragmentKey
import com.srg.pruebamarvel.common.di.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.contracts.ExperimentalContracts

/**
 * Created by sebrodgar on 28/02/2021.
 */
@ExperimentalCoroutinesApi
@Module
abstract class CharacterDetailsAppearanceDialogFragmentBuilder {

    @Binds
    @IntoMap
    @FragmentKey(CharacterDetailsAppearanceDialogFragment::class)
    @ExperimentalContracts
    abstract fun bindCharacterDetailsAppearanceDialogFragment(fragment: CharacterDetailsAppearanceDialogFragment): Fragment

    @Binds
    @IntoMap
    @ViewModelKey(CharacterDetailsAppearanceDialogViewModel::class)
    abstract fun bindCharacterDetailsAppearanceDialogViewModel(viewModel: CharacterDetailsAppearanceDialogViewModel): ViewModel
}
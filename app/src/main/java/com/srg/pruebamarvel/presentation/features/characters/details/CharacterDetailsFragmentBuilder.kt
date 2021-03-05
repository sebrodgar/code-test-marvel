package com.srg.pruebamarvel.presentation.features.characters.details

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.srg.pruebamarvel.common.di.annotations.FragmentKey
import com.srg.pruebamarvel.common.di.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.contracts.ExperimentalContracts

/**
 * Created by sebrodgar on 28/02/2021.
 */
@Module
abstract class CharacterDetailsFragmentBuilder {

    @Binds
    @IntoMap
    @FragmentKey(CharacterDetailsFragment::class)
    @ExperimentalContracts
    abstract fun bindCharacterDetailsFragment(fragment: CharacterDetailsFragment): Fragment

    @Binds
    @IntoMap
    @ViewModelKey(CharacterDetailsViewModel::class)
    abstract fun bindCharacterDetailsViewModel(viewModel: CharacterDetailsViewModel): ViewModel
}
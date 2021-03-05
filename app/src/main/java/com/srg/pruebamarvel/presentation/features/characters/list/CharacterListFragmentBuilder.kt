package com.srg.pruebamarvel.presentation.features.characters.list

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
abstract class CharacterListFragmentBuilder {

    @Binds
    @IntoMap
    @FragmentKey(CharacterListFragment::class)
    @ExperimentalContracts
    abstract fun bindCharacterListFragment(fragment: CharacterListFragment): Fragment

    @Binds
    @IntoMap
    @ViewModelKey(CharacterListViewModel::class)
    abstract fun bindCharacterListViewModel(viewModel: CharacterListViewModel): ViewModel
}
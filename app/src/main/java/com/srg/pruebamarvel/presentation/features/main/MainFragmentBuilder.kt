package com.srg.pruebamarvel.presentation.features.main

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
abstract class MainFragmentBuilder {

    @Binds
    @IntoMap
    @FragmentKey(MainFragment::class)
    @ExperimentalContracts
    abstract fun bindMainFragment(fragment: MainFragment): Fragment

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}
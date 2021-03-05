package com.srg.pruebamarvel.presentation.features.characters.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.srg.pruebamarvel.R
import com.srg.pruebamarvel.common.base.BaseFragment
import com.srg.pruebamarvel.common.di.injections.ViewModelInjectionFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CharacterDetailsFragment @Inject constructor(
    private val vmf: ViewModelInjectionFactory
) : BaseFragment(R.layout.fragment_character_details) {

    private val viewModel by viewModels<CharacterDetailsViewModel> { vmf }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        viewModel.getCharacters()
    }

    private fun initObservers() {
        viewModel.characters.observe(viewLifecycleOwner, {
            print(it)
        })
    }
}
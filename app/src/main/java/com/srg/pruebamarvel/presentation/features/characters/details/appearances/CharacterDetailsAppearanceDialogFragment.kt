package com.srg.pruebamarvel.presentation.features.characters.details.appearances

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.srg.pruebamarvel.R
import com.srg.pruebamarvel.common.base.ExpandedBottomSheetDialogFragment
import com.srg.pruebamarvel.common.di.injections.ViewModelInjectionFactory
import com.srg.pruebamarvel.common.util.StateData
import com.srg.pruebamarvel.databinding.FragmentCharacterAppearanceListBinding
import com.srg.pruebamarvel.presentation.common.extensions.setUpToolbar
import com.srg.pruebamarvel.presentation.common.extensions.showError
import com.srg.pruebamarvel.presentation.common.viewBinding
import com.srg.pruebamarvel.presentation.features.characters.details.appearances.lists.ListAdapter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CharacterDetailsAppearanceDialogFragment @Inject constructor(
    private val vmf: ViewModelInjectionFactory
) : ExpandedBottomSheetDialogFragment(R.layout.fragment_character_appearance_list) {

    private val viewModel by viewModels<CharacterDetailsAppearanceDialogViewModel> { vmf }
    private val binding by viewBinding(FragmentCharacterAppearanceListBinding::bind)
    private val adapter = ListAdapter()
    private val args: CharacterDetailsAppearanceDialogFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers(view.context)
        initUi(view.context)
    }

    private fun initUi(context: Context) {
        setUpToolbar(binding.toolbar)
        binding.toolbar.title = context.getString(R.string.characters_appearance_title_screen)
        binding.toolbar.navigationIcon = ContextCompat.getDrawable(context, R.drawable.ic_close)
        getCharacters()
    }

    override fun onStart() {
        super.onStart()
        binding.nsvCharacters.isEnabled = true
        binding.rvCharacters.adapter = adapter
    }

    override fun onStop() {
        super.onStop()
        binding.nsvCharacters.isEnabled = false
        binding.rvCharacters.adapter = null
    }

    private fun initObservers(context: Context) {
        viewModel.charactersAppearance.observe(viewLifecycleOwner, {
            when (it) {
                is StateData.Content -> {
                    adapter.submitList(adapter.currentList.plus(it.content))
                }
                is StateData.Error -> {
                    showError(context, it.error) {
                        getCharacters()
                    }

                }
            }
        })
    }

    private fun getCharacters() {
        viewModel.getCharacters(args.character)
    }
}
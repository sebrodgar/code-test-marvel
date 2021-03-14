package com.srg.pruebamarvel.presentation.features.characters.details

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.srg.pruebamarvel.R
import com.srg.pruebamarvel.common.base.BaseFragment
import com.srg.pruebamarvel.common.di.injections.ViewModelInjectionFactory
import com.srg.pruebamarvel.common.util.StateData
import com.srg.pruebamarvel.databinding.FragmentCharacterDetailsBinding
import com.srg.pruebamarvel.presentation.common.extensions.setUpToolbar
import com.srg.pruebamarvel.presentation.common.extensions.showError
import com.srg.pruebamarvel.presentation.common.viewBinding
import com.srg.pruebamarvel.presentation.features.characters.models.CharacterUiModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CharacterDetailsFragment @Inject constructor(
    private val vmf: ViewModelInjectionFactory
) : BaseFragment(R.layout.fragment_character_details) {

    private val viewModel by viewModels<CharacterDetailsViewModel> { vmf }
    private val binding by viewBinding(FragmentCharacterDetailsBinding::bind)
    private val args: CharacterDetailsFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi(view.context)
        initObservers(view.context)
        viewModel.getCharacter(args.character.id)
        getCharacter()
        setListeners()
    }

    private fun initUi(context: Context) {
        setUpToolbar(binding.toolbar)
        binding.toolbar.title = args.character.name
        updateUi(context, args.character)
    }

    private fun setListeners() {
        binding.btShowAppearances.setOnClickListener {
            navigateToCharacterAppearances()
        }
    }

    private fun initObservers(context: Context) {
        viewModel.character.observe(viewLifecycleOwner, {
            when (it) {
                is StateData.Content -> {
                    updateUi(context, it.content)
                }
                is StateData.Error -> {
                    showError(context, it.error) {
                        getCharacter()
                    }
                }
            }
        })
    }

    private fun getCharacter() {
        viewModel.getCharacter(args.character.id)
    }

    private fun updateUi(context: Context, characterUiModel: CharacterUiModel) {
        Glide.with(context).load(characterUiModel.imageURL).into(binding.ivCharacterImage)
        binding.tvCharacterDescription.text = characterUiModel.description
        binding.tvCharacterModifiedDate.text = context.getString(
            R.string.character_details_modified_data,
            characterUiModel.modifiedData
        )
        isLoaded()
    }

    private fun isLoaded() {
        binding.tvCharacterDescription.isInvisible = false
        binding.tvCharacterModifiedDate.isInvisible = false
        binding.ivCharacterImage.isInvisible = false
        binding.pbCharacterDetails.isVisible = false
    }

    private fun navigateToCharacterAppearances() {
        findNavController().navigate(
            CharacterDetailsFragmentDirections.actionCharacterDetailsFragmentToCharacterDetailsAppearanceDialogFragment(
                args.character
            )
        )
    }
}
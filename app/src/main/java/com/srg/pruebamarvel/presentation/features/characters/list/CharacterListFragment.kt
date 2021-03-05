package com.srg.pruebamarvel.presentation.features.characters.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.srg.pruebamarvel.R
import com.srg.pruebamarvel.common.base.BaseFragment
import com.srg.pruebamarvel.common.di.injections.ViewModelInjectionFactory
import com.srg.pruebamarvel.common.util.StateData
import com.srg.pruebamarvel.databinding.FragmentCharacterListBinding
import com.srg.pruebamarvel.presentation.common.errors.DialogErrorViewEntity
import com.srg.pruebamarvel.presentation.common.listeners.OnBottomReachedListener
import com.srg.pruebamarvel.presentation.common.listeners.OnItemClickListener
import com.srg.pruebamarvel.presentation.common.viewBinding
import com.srg.pruebamarvel.presentation.features.characters.list.models.CharacterItemUiModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CharacterListFragment @Inject constructor(
    private val vmf: ViewModelInjectionFactory
) : BaseFragment(R.layout.fragment_character_list), OnItemClickListener<CharacterItemUiModel>,
    OnBottomReachedListener {

    private val viewModel by viewModels<CharacterListViewModel> { vmf }
    private val binding by viewBinding(FragmentCharacterListBinding::bind)
    private val adapter = CharacterListAdapter(this, this)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers(view)
        setListeners()
        getCharacters()
    }

    override fun onStart() {
        super.onStart()
        binding.srlCharacters.isEnabled = true
        binding.rvCharacters.adapter = adapter
    }

    private fun setListeners() {
        binding.srlCharacters.setOnRefreshListener {
            getCharacters()
        }
    }

    private fun getCharacters() = viewModel.getCharacters()

    private fun initObservers(view: View) {
        viewModel.characters.observe(viewLifecycleOwner, {
            when (it) {
                is StateData.Loading -> binding.srlCharacters.isRefreshing = true
                is StateData.Content -> {
                    adapter.submitList(adapter.currentList.plus(it.content))
                    binding.srlCharacters.isRefreshing = false
                }
                is StateData.Error -> {
                    showError(view, it.error) {
                        getCharacters()
                    }

                }
            }
        })
    }

    private fun showError(
        view: View,
        dialogErrorViewEntity: DialogErrorViewEntity,
        onPositiveButtonPressed: () -> Unit = {}
    ) =
        MaterialAlertDialogBuilder(view.context)
            .setCancelable(false)
            .setTitle(dialogErrorViewEntity.dialogTitle)
            .setMessage(dialogErrorViewEntity.dialogMessage)
            .setPositiveButton(dialogErrorViewEntity.positiveButton) { _, _ ->
                onPositiveButtonPressed()
            }
            .show()

    override fun onItemClick(t: CharacterItemUiModel) {

    }

    override fun onBottomReached(position: Int) = getCharacters()

}
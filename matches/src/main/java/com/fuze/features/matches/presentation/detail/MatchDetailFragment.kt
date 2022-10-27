package com.fuze.features.matches.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.fuze.commons.bindings.visible
import com.fuze.core.di.factory.ViewModelFactory
import com.fuze.features.matches.databinding.FragmentMatchDetalBinding
import com.fuze.features.matches.presentation.MatchesActivity
import com.fuze.features.matches.presentation.detail.adapter.PlayersAdapter
import com.fuze.features.matches.presentation.list.mapper.toMatchResumeUiModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MatchDetailFragment @Inject constructor(): Fragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MatchDetailViewModel by viewModels { viewModelFactory }

    private val adapter = PlayersAdapter()

    lateinit var binding: FragmentMatchDetalBinding

    val args: MatchDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMatchDetalBinding.inflate(layoutInflater)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() {
                    if (!findNavController().popBackStack()) {
                        activity?.finish()
                    }
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupRecyclerView()

        args.let {
            it.matchModel.let { match ->
                binding.clashTeams.model = match.toMatchResumeUiModel().clashTeamsUiModel
                binding.dateTextView.text = match.toMatchResumeUiModel().time
                viewModel.fetchPlayers(match.id)
                (requireActivity() as MatchesActivity).toolbar.title = match.league.name
            }

        }
        binding.tryAgainButton.setOnClickListener {
            viewModel.fetchPlayers(args.matchModel.id)
        }
    }

    private fun setupRecyclerView() {
        binding.playersRecyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.list.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.stateList.observe(viewLifecycleOwner) {
            binding.progressBar.visible = it.isLoading()
            binding.emptyListContainer.visible = it.isEmpty()
            binding.errorContainer.visible = it.isError()
            binding.playersRecyclerView.visible = it.isLoaded() || it.isRefreshing()
        }
        viewModel.errorMessage.observe(viewLifecycleOwner){
            binding.errorDescription.text = it
        }
    }
}
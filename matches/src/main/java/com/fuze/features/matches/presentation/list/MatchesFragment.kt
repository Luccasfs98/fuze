package com.fuze.features.matches.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.fuze.commons.bindings.visible
import com.fuze.core.di.factory.ViewModelFactory
import com.fuze.features.matches.databinding.FragmentMatchesBinding
import com.fuze.features.matches.presentation.list.adapter.MatchesAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MatchesFragment @Inject constructor(): Fragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MatchesViewModel by viewModels { viewModelFactory }

    private val adapter = MatchesAdapter {
        findNavController().navigate(MatchesFragmentDirections.startDetailFragment(it))
    }

    lateinit var binding: FragmentMatchesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMatchesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            setupObservers()
            setupRecyclerView()
        }
        binding.swipe.setOnRefreshListener {
            viewModel.fetchMatches(true)
        }
        binding.tryAgainButton.setOnClickListener {
            viewModel.fetchMatches(true)
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.list.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.stateList.observe(viewLifecycleOwner) {
            binding.swipe.isRefreshing = it.isRefreshing()
            binding.progressBar.visible = it.isLoading()
            binding.emptyListContainer.visible = it.isEmpty()
            binding.errorContainer.visible = it.isError()
            binding.recyclerView.visible = it.isLoaded() || it.isRefreshing()
        }
        viewModel.errorMessage.observe(viewLifecycleOwner){
            binding.errorDescription.text = it
        }
    }
}
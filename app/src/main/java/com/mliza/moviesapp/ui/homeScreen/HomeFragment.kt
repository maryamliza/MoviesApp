package com.mliza.moviesapp.ui.homeScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mliza.moviesapp.R
import com.mliza.moviesapp.data.models.Movie
import com.mliza.moviesapp.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObservers()
        viewModel.getMovies()
    }

    private fun setupObservers() {
        viewModel.listMoviesFiltered.observe(viewLifecycleOwner, Observer {
            binding.ivNoInternet.isVisible = false
            binding.rcMovie.isVisible = true
            binding.swiperefresh.isRefreshing = false
            binding.rcMovie.adapter = HomeAdapter(it, ::openMovieDetail)
        })
        viewModel.error.observe(viewLifecycleOwner, Observer {
            binding.swiperefresh.isRefreshing = false
            showNetworkError()
        })
    }

    private fun openMovieDetail(movie: Movie) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(movie.id)
        findNavController().navigate(action)
    }

    private fun showNetworkError() {
        binding.ivNoInternet.isVisible = true
        binding.rcMovie.isVisible = false

        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.no_internet_title))
            .setMessage(getString(R.string.no_internet_message))
            .setPositiveButton(getString(R.string.ok)) { _, _ -> }
            .show()
    }

    private fun setupViews() {
        binding.etSearch.addTextChangedListener {
            viewModel.filter(it.toString())
        }
        binding.swiperefresh.setOnRefreshListener {
            viewModel.getMovies()
        }
    }
}
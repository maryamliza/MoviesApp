package com.mliza.moviesapp.ui.detailScreen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.mliza.moviesapp.data.models.Movie
import com.mliza.moviesapp.databinding.FragmentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {
    val viewModel: DetailViewModel by viewModel()
    private lateinit var binding: FragmentDetailBinding
    val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObservers()
    }

    private fun setupViews() {
        val id = args.id
        viewModel.getMovieDetail(id)
    }


    private fun setupObservers() {
        viewModel.detailMovie.observe(viewLifecycleOwner) {
            updateMovieInfo(movie = it)
        }
    }

    private fun updateMovieInfo(movie: Movie) {
        binding.container.isVisible = true
        binding.loading.isVisible = false
        binding.tvMovieName.text = movie.name
        binding.tvGenre.text = movie.genre
        binding.tvRating.text = movie.rating.toString()
        binding.tvMaps.text = movie.origin.country
        binding.textYear.text = movie.year
        binding.textDuration.text = movie.duration
        binding.tvDescription.text = movie.description
        binding.tvActors.text = movie.actors.joinToString(separator = ", ")
        binding.tvDirectors.text = movie.directors.joinToString(separator = ", ")

        Glide.with(binding.ivImage.context)
            .load(movie.imageUrl)
            .into(binding.ivImage)

        binding.btMaps.setOnClickListener {
            findNavController().navigate(
                DetailFragmentDirections.actionDetailFragmentToMapFragment(
                    movie
                )
            )
        }
    }

    private fun openMaps(movie: Movie) {
        val latitude = movie.origin.latitude.toString()
        val longitude = movie.origin.longitude.toString()
        val ubication = "geo:0,0?q=$latitude,$longitude"

        val gmmIntentUri = Uri.parse(ubication)
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }

    private fun openCall(phone: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
        startActivity(intent)
    }
}

package com.example.freemovies.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.freemovies.R
import com.example.freemovies.databinding.FragmentMovieDetailesBinding
import com.example.freemovies.db.MovieDatabase
import com.example.freemovies.model.FavoriteMovies
import com.example.freemovies.repository.FavmovieRepoImpl
import com.example.freemovies.repository.FavouriteRepo
import com.example.freemovies.viewmodel.FavViewModel
import com.example.freemovies.viewmodel.FavViewModelFactory
import kotlinx.android.synthetic.main.fragment_movie_detailes.view.*


class MovieDetailesFragment : Fragment() {

    private lateinit var detailes: TextView
    private lateinit var repo: FavouriteRepo

    private val database by lazy { MovieDatabase.getDataBase(context) }
    private val repository by lazy { FavmovieRepoImpl(database.getMovieDataDao()) }


    private val FavviewModel: FavViewModel by lazy {
        ViewModelProvider(this, FavViewModelFactory(repository))
            .get(FavViewModel::class.java)
    }

    companion object {
        fun newInstance1() = MovieDetailesFragment()
    }

    private lateinit var binding: FragmentMovieDetailesBinding
    // private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentMovieDetailesBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var bundle = arguments
        // strtext = getArguments()?.getString("key").toString()
        val strtext = bundle!!.getString("key")
        binding.about.text = strtext

        val id = bundle!!.getString("id")
        val ID = id?.toInt()

      //  val Img = bundle!!.getString("IMG")

        val Img = "https://image.tmdb.org/t/p/original" + bundle!!.getString("IMG")
        Glide.with(requireContext())
            .load(Img)
            .into( binding.moviePoster)

        val URL = "https://image.tmdb.org/t/p/original" + bundle!!.getString("uRl")
        Glide.with(requireContext())
            .load(URL)
            .centerCrop()
            .into(binding.DetailImg)

        val aboutmovie = bundle!!.getString("about")
        binding.about.text = aboutmovie


    binding.cheakbox2.setOnClickListener {
        if (binding.cheakbox2.isChecked) {
            if (URL != null && strtext != null && ID != null) {
                FavviewModel.insertMovieData(
                    FavoriteMovies(
                        id = ID,
                        name = strtext,
                        posterPath = URL
                    ))
            }
            Toast.makeText(requireContext(), "added to favorite", Toast.LENGTH_SHORT).show()
        } else {
            if (URL != null && strtext != null && ID != null)
                FavviewModel.removeFromFavorite(
                    FavoriteMovies(//7
                        id = ID,
                        name = strtext,
                        posterPath = URL
                    ))
            Toast.makeText(requireContext(), "removed from favorites", Toast.LENGTH_SHORT)
                .show()
            }
        }

    }
}

       /* binding.favBtn.setOnClickListener() {
            /* //passing data from one fragment to another
             val mFragment = FavoriteFragment()
            val bundle = Bundle()
            bundle.putString("URl",URL)
            mFragment.arguments = bundle
            findNavController().navigate(R.id.favoriteFragment, bundle)*/


            if (URL != null && strtext != null && ID != null) {
                FavviewModel.insertMovieData(
                    FavoriteMovies(
                        id = ID,
                        name = strtext,
                        posterPath = URL
                    )
                )
            }

            Toast.makeText(requireContext(), "added to favorite", Toast.LENGTH_SHORT).show()
        }*/


          /*  binding.checkBox.setOnClickListener {
                // if (binding.checkBox.isChecked) {

                if (URL != null && strtext != null && ID != null)
                    FavviewModel.removeFromFavorite(
                        FavoriteMovies(//7
                            id = ID,
                            name = strtext,
                            posterPath = URL
                        )
                    )
                Toast.makeText(requireContext(), "removed from favorites", Toast.LENGTH_SHORT)
                    .show()
                }

                if (ID != null) {
                FavviewModel.exists(MovieID = ID)
                // binding.checkBox.isChecked

            }*/

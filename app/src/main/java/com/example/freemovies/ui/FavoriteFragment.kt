package com.example.freemovies.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.collect
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.freemovies.databinding.FragmentFavoriteBinding
import com.example.freemovies.db.MovieDatabase
import com.example.freemovies.repository.FavmovieRepoImpl
import com.example.freemovies.viewmodel.FavViewModel
import com.example.freemovies.viewmodel.FavViewModelFactory
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch


class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private val favAdapter = FavMovieAdapter(ArrayList())


    private val database by lazy { MovieDatabase.getDataBase(context) }
    private val repository by lazy { FavmovieRepoImpl(database.getMovieDataDao()) }


    //private val database by lazy{ context?.let { MovieDatabase.getDatabase(it) } }
    // private val repository by lazy { database?.let { FavmovieRepoImpl(it.getMovieDataDao()) } }

    // private lateinit var FavviewModel = FavViewModel()

    private val FavviewModel: FavViewModel by lazy {
        ViewModelProvider(this, FavViewModelFactory(repository))
            .get(FavViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       /* var bundle = arguments
        if (bundle != null) {
            val strtext = bundle!!.getString("URl")
            Glide.with(requireContext()).load(strtext).into(binding.favMovieImg)*/


            binding.recycleviewFav.layoutManager = GridLayoutManager(requireContext(), 3)
            binding.recycleviewFav.adapter = favAdapter

            /* lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    FavviewModel.favmoviesList.collect {
                        binding.recycleviewFav.visibility = View.VISIBLE
                         binding.progressBar2.visibility = View.GONE
                        if (it != null) {
                            favAdapter.updatefavMovieList(it)
                        }
                    }
                }
            }*/
            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    FavviewModel.favmoviesList.observe(viewLifecycleOwner, { favmoviesList ->
                        favmoviesList?.let { favmoviesLists ->

                            binding.recycleviewFav.visibility = View.VISIBLE
                            binding.progressBar2.visibility = View.GONE

                            favAdapter.updatefavMovieList(favmoviesLists)
                        }

                    })
                }
            }
        }
    }





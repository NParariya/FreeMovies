package com.example.freemovies.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.freemovies.R
import com.example.freemovies.databinding.FragmentHomeBinding
import com.example.freemovies.model.MovieData
import com.example.freemovies.model.Movies
import com.example.freemovies.viewmodel.MainViewModel
import com.example.freemovies.viewmodel.ViewModelFactory
import com.example.nmoviesapp.NewAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    companion object {
        fun newInstance() = HomeFragment()
    }


    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel : MainViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory())
            .get(MainViewModel::class.java)
    }

       // private var userAdapter = MovieAdapter(ArrayList(),{selectedMovie:MovieData -> MovieClicked(selectedMovie)})

      private var userAdapter = NewAdapter(ArrayList() ,{selectedMovie: Movies -> MoviesClicked(selectedMovie)})

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*userAdapter.setOnItemClickListner {
            val bundle= Bundle().apply {
                putSerializable("selected_movie",it)
            }
           // findNavController().navigate(R.id.action_homeFragment_to_movieDetailesFragment, bundle)
        }*/
        /**remove refresh fn for movies */
        //viewModel.refresh()
        binding.recyclerview.layoutManager = GridLayoutManager(requireContext(),3)
        binding.recyclerview.adapter = userAdapter



       // userAdapter.updateMovieList(Movies)


        /* fun onTopRatedMoviesFetched(movies: List<Movies>) {
            userAdapter.updateMovies(movies)

        }*/

        /**changed - add this for movies*/

        binding.recyclerview.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
        viewModel.userList.observe(viewLifecycleOwner, { movie ->
            movie.let { list ->
                userAdapter?.updateMovieList(list.movies!!)

            }

        })



           /*  lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.userList.collect {

                        binding.recyclerview.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                    if (it != null) {
                        userAdapter.updateMovieList(it)
                    }
                }
             }

            }*/
    }

    fun MoviesClicked(movie : Movies){
        val mFragment = MovieDetailesFragment()
        val bundle = Bundle()
        bundle.putString("key",movie.title.toString())
        bundle.putString("uRl",movie.backdropPath.toString())
        bundle.putString("id",movie.id.toString())
        bundle.putString("about",movie.overview.toString())
        bundle.putString("IMG", movie.posterPath)
        mFragment.arguments = bundle

        findNavController().navigate(R.id.action_homeFragment_to_movieDetailesFragment, bundle)

    }

/**changes MovieData to Movies*/
    fun MovieClicked(emp: MovieData){

        /*requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.activitymain, MovieDetailesFragment.newInstance1())
            .commitNow()*/
        val mFragment = MovieDetailesFragment()
        val bundle = Bundle()
        bundle.putString("key",emp.id.toString())
        bundle.putString("uRl",emp.url.toString())
        bundle.putString("id",emp.ids.toString())
        bundle.putString("about",emp.temperament.toString())
        mFragment.arguments = bundle

        //Inflate the fragment
        findNavController().navigate(R.id.action_homeFragment_to_movieDetailesFragment, bundle)
        //Toast.makeText(requireContext(),"Dog's age is ${emp.id}", Toast.LENGTH_SHORT).show()
    }




}






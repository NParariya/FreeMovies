package com.example.freemovies

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.FragmentTransitionSupport
import com.example.freemovies.databinding.FragmentHomeBinding
import com.example.freemovies.model.MovieData
import com.example.freemovies.viewmodel.MainViewModel
import com.example.freemovies.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_home.*
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
    //error yha aayegaa
    private var userAdapter = MovieAdapter(ArrayList(),{selectedMovie:MovieData -> MovieClicked(selectedMovie)})


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

            viewModel.refresh()
            binding.recyclerview.layoutManager = GridLayoutManager(requireContext(),3)
            binding.recyclerview.adapter = userAdapter

            lifecycleScope.launch{
                repeatOnLifecycle(Lifecycle.State.STARTED){
                    viewModel.userList.collect{
                        if (it != null) {

                            binding.recyclerview.visibility = View.VISIBLE
                            binding.progressBar.visibility = View.GONE
                            userAdapter.updateMovieList(it)
                        }
                    }
                }


            }

    }

   fun MovieClicked(emp: MovieData){

        /*requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.activitymain, MovieDetailesFragment.newInstance1())
            .commitNow()*/

       //val bundle = Bundle()
       //bundle.putString("key",emp.toString())


        //Inflate the fragment
       findNavController().navigate(R.id.action_homeFragment_to_movieDetailesFragment)
        Toast.makeText(requireContext(),"Dog's name is ${emp.name}", Toast.LENGTH_SHORT).show()
    }



}


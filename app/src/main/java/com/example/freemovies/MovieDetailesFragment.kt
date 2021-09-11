package com.example.freemovies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.freemovies.databinding.FragmentMovieDetailesBinding
import com.example.freemovies.model.MovieData
import kotlinx.android.synthetic.main.fragment_movie_detailes.*

class MovieDetailesFragment : Fragment() {
    companion object {
    fun newInstance1() = MovieDetailesFragment()
}
       lateinit var  binding : FragmentMovieDetailesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val inputText = arguments?.getString("key")

        //binding.detailes.text = inputText

        return inflater.inflate(R.layout.fragment_movie_detailes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /* binding = FragmentMovieDetailesBinding.bind(view)
        val args: MovieDetailesFragment by navArgs()
         val emp = args.selectedMovie
         binding.mvInfo.apply {
             webViewClient = WebViewClient()
             if (MovieData.url != "") {
                 loadurl = MovieData.url
             }
         }

         binding.wvInfo

     }*/

}
}
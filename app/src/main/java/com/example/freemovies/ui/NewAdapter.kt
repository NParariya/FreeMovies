package com.example.nmoviesapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.freemovies.R
import com.example.freemovies.databinding.ViewTypeBinding
import com.example.freemovies.model.Movies

class NewAdapter(
    private var movies: List<Movies>,
    private val clickListener: (Movies)->Unit
   /* private val onMovieClick: (movie : Movies) -> Unit*/
) : RecyclerView.Adapter<NewAdapter.MovieViewHolder>() {

    fun updateMovieList (list : List<Movies>) {
        this.movies = list
            // this.movies.addAll(data)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding :ViewTypeBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.view_type, parent, false)

        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        holder.bind(movies[position])

        holder.binding.binder = movies.get(position)
    }

    fun updateMovies(movies: List<Movies>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(var binding: ViewTypeBinding) : RecyclerView.ViewHolder(binding.root) {

        //private val poster: ImageView = itemView.findViewById(R.id.movieimg)
       // private val title : TextView = itemView.findViewById(R.id.textView1)

        fun bind(movie: Movies) {
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/original${movie.posterPath}")
                .transform(CenterCrop())
                .into(binding.movieimg)

           // title.text = movie.title


            itemView.setOnClickListener(){
                clickListener(movie)
            }

           /* itemView.setOnClickListener { onMovieClick.invoke(movie) }*/


        }
    }
}
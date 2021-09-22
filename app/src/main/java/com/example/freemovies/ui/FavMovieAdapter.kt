package com.example.freemovies.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.freemovies.R
import com.example.freemovies.databinding.ViewTypeBinding
import com.example.freemovies.databinding.ViewTypeFavBinding
import com.example.freemovies.model.FavoriteMovies
import com.example.freemovies.model.MovieData

class FavMovieAdapter(private var favmovieList : List<FavoriteMovies>): RecyclerView.Adapter<FavMovieAdapter.MainViewHolder>() {


     var favmovies: MutableList<FavoriteMovies> = mutableListOf()

   // var  favmovies :LiveData<List<FavoriteMovies>> = MutableLiveData()

    fun updatefavMovieList (data: List<FavoriteMovies>) {
        this.favmovies.clear()
        this.favmovies.addAll(data)
        notifyDataSetChanged()
    }

    class MainViewHolder(var binding: ViewTypeFavBinding) : RecyclerView.ViewHolder(binding.root) {

        fun Bind(emp: FavoriteMovies) {
            binding.textView1.text = emp.name
            Glide.with(itemView.context).load(emp.posterPath).into(binding.movieimg)
        }
    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewTypeFavBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.view_type_fav, parent, false)

        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
         holder.Bind(favmovies[position])
    }

    override fun getItemCount() : Int{
        return favmovies.size
    }


}



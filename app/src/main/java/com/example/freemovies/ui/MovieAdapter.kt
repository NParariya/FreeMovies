package com.example.freemovies.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.freemovies.R
import com.example.freemovies.databinding.ViewTypeBinding
import com.example.freemovies.model.MovieData

class MovieAdapter(private var movieList : List<MovieData>,private val clickListener: (MovieData)->Unit) :RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var dataSet: MutableList<MovieData> = mutableListOf()

    fun updateMovieList (data: List<MovieData>) {
        this.dataSet.clear()
        this.dataSet.addAll(data)
        notifyDataSetChanged()

    }

   /* fun updateMovieList(dataset: List<MovieData>) {
        this.movieList = dataset
        notifyDataSetChanged()
    }*/

    class ViewHolder(var binding: ViewTypeBinding) : RecyclerView.ViewHolder(binding.root) {
        //val textview: TextView = view.findViewById(R.id.textView)
        //val textview1: TextView = view.findViewById(R.id.textView1)
        //val textview2: TextView = view.findViewById(R.id.textView2)
        //val image : ImageView = view.findViewById(R.id.movieimg)

        fun Bind(emp: MovieData,  clickListener: (MovieData)->Unit){
            //val emp = dataSet[position]
            //textview2.text = emp.id
            //textview1.text = emp.name
            //textview.text = emp.group

            //url help  "https://image.tmdb.org/t/p/w500"+

            Glide.with(itemView.context).load( emp.url).into(binding.movieimg)

           /* itemView.rootView.setOnClickListener{
             onItemClickListner?.let {
                 it(emp)
             }
            }*/


            itemView.setOnClickListener(){
                clickListener(emp)
            }
        }


    }


    /* fun setOnItemClickListner(listener: (MovieData)->Unit){
         var onItemClickListner :((MovieData)->Unit)? = null
         onItemClickListner = listener

     }*/




    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val binding : ViewTypeBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.view_type, viewGroup, false)

        return ViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        //  dataSet[position].run {
        /**changed*/
        viewHolder.Bind(dataSet[position] ,clickListener)

        var binding : ViewTypeBinding
        /**changed*/
       // viewHolder.binding.binder = (dataSet.get(position))
    }



    // Return the size of your dataset (invoked by the layout manager)
    /**changed*/
    override fun getItemCount() = dataSet.size

}

package com.example.freemovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.freemovies.model.MovieData

class MovieAdapter(private var movieList : ArrayList<MovieData>,private val clickListener: (MovieData)->Unit) :RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var dataSet: MutableList<MovieData> = mutableListOf()

    fun updateMovieList (data: List<MovieData>) {
        this.dataSet.clear()
        this.dataSet.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textview: TextView = view.findViewById(R.id.textView)
        val textview1: TextView = view.findViewById(R.id.textView1)
        val textview2: TextView = view.findViewById(R.id.textView2)
        val image : ImageView = view.findViewById(R.id.movieimg)

        fun Bind(emp: MovieData,  clickListener: (MovieData)->Unit){
            //val emp = dataSet[position]

            textview2.text = emp.id
            textview1.text = emp.name
            //textview.text = emp.group

            //url help  "https://image.tmdb.org/t/p/w500"+

            Glide.with(itemView.context).load( emp.url).into(image)



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
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.view_type, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //  dataSet[position].run {
        viewHolder.Bind(dataSet[position] ,clickListener)
        /* val emp = dataSet[position]

            viewHolder.textview.text = emp.id
           viewHolder.textview1.text = emp.name
           viewHolder.textview2.text = emp.group

            Glide.with(viewHolder.itemView.context).load(emp.url).into(viewHolder.image)


        }*/
    }



    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
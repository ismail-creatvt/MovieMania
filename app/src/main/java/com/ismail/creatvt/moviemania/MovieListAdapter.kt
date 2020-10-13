package com.ismail.creatvt.moviemania

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item_layout.view.*

class MovieListAdapter(val movies:ArrayList<MovieItem>): RecyclerView.Adapter<MovieListAdapter.MovieListItemViewHolder>() {

    class MovieListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.movie_item_layout, parent, false)
        return MovieListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieListItemViewHolder, position: Int) {
        //Set the data for a single movie item
        val movie = movies[position]
        holder.itemView.name_text.setText(movie.name)
        holder.itemView.genre_text.setText(movie.genres.joinToString(","))
        holder.itemView.overview_text.setText(movie.overview)

        Glide.with(holder.itemView)
            .load(movie.imageUrl)
            .into(holder.itemView.poster_image)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}
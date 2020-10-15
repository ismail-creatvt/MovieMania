package com.ismail.creatvt.moviemania

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ismail.creatvt.moviemania.model.MovieItem
import kotlinx.android.synthetic.main.movie_item_layout.view.*

/***
 * This adapter will be responsible for showing the list of movie items in all
 * the screens like "Upcoming", "Top Rated", etc
 *
 * It will take the list of MovieItems
 * @see MovieItem
 *
 */
class MovieListAdapter(val movies: ArrayList<MovieItem>) :
    RecyclerView.Adapter<MovieListAdapter.MovieListItemViewHolder>() {

    class MovieListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    /**
     * Whenever the list of movies will be updated
     * this method should be called
     * It will update the list and refresh the UI
     */
    fun updateItems(newList: List<MovieItem>) {
        movies.clear() //Removes all items from the list
        movies.addAll(newList) //Inserts the updated list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.movie_item_layout, parent, false)
        return MovieListItemViewHolder(view)
    }


    /**
     * This method will do the work of setting the data on the UI elements
     *
     * It will also load images from URL using Glide
     */
    override fun onBindViewHolder(holder: MovieListItemViewHolder, position: Int) {
        //Set the data for a single movie item
        val movie = movies[position]
        holder.itemView.name_text.text = movie.title

        val genres = movie.genreIds.joinToString(", ", transform = {
            Utility.genreMap[it] ?: ""
        })
        holder.itemView.genre_text.text = genres
        holder.itemView.overview_text.text = movie.overview


        //We are using Glide to load images
        //because it is a specialized library for image loading and caching
        //and it does some optimizations
        Glide.with(holder.itemView)
            .load(Utility.getThumbnailURL(movie.posterPath))
            .into(holder.itemView.poster_image)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}
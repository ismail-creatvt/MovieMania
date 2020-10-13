package com.ismail.creatvt.moviemania.features

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ismail.creatvt.moviemania.MovieItem
import com.ismail.creatvt.moviemania.MovieListAdapter
import com.ismail.creatvt.moviemania.R
import kotlinx.android.synthetic.main.fragment_movies_list.view.*

class MovieListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movie = MovieItem(
            "Iron Man 3",
            "When Tony Stark's world is torn apart by a formidable terrorist called the Mandarin, he starts an odyssey of rebuilding and retribution.",
            "2013",
            "https://image.tmdb.org/t/p/w500/g2GvVhKxKKZhcvbgukgvDHcYhsI.jpg",
            arrayOf("Action", "Adventure", "Science Fiction")
        )

        val movieList = arrayListOf(
            movie,
            movie,
            movie,
            movie,
            movie,
            movie,
            movie,
            movie,
            movie,
            movie
        )
        view.movie_list_rv.adapter = MovieListAdapter(movieList)
        view.movie_list_rv.layoutManager = LinearLayoutManager(context)
    }
}
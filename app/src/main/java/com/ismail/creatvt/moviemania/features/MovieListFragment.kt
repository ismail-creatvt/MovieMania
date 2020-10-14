package com.ismail.creatvt.moviemania.features

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ismail.creatvt.moviemania.model.MovieItem
import com.ismail.creatvt.moviemania.MovieListAdapter
import com.ismail.creatvt.moviemania.R
import com.ismail.creatvt.moviemania.RetrofitFactory
import com.ismail.creatvt.moviemania.api.MovieListService
import com.ismail.creatvt.moviemania.model.MoviePageResponse
import kotlinx.android.synthetic.main.fragment_movies_list.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListFragment : Fragment(), Callback<MoviePageResponse> {

    private var adapter: MovieListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit = RetrofitFactory.getInstance()
        val movieListService = retrofit.create(MovieListService::class.java)

        val call = movieListService.getTopRatedMovies()

        call.enqueue(this)

        adapter = MovieListAdapter(arrayListOf())
        view.movie_list_rv.adapter = adapter
        view.movie_list_rv.layoutManager = LinearLayoutManager(context)
    }

    override fun onResponse(
        call: Call<MoviePageResponse>,
        response: Response<MoviePageResponse>
    ) {
        //Successful response from API
        if(response.body() != null){
            val movieResponse = response.body() as MoviePageResponse
            adapter?.updateItems(movieResponse.results)
        }
    }

    override fun onFailure(call: Call<MoviePageResponse>, t: Throwable) {
        Log.d("Exception", "Reason : ${t.message}")
    }

}
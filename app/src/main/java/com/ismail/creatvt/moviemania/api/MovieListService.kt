package com.ismail.creatvt.moviemania.api

import com.ismail.creatvt.moviemania.Utility
import com.ismail.creatvt.moviemania.Utility.API_KEY
import com.ismail.creatvt.moviemania.model.MovieItem
import com.ismail.creatvt.moviemania.model.MoviePageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieListService {

    @GET("movie/{endPoint}/")
    fun getMoviesList(
        @Path("endPoint") endPoint: String,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): Call<MoviePageResponse>

}
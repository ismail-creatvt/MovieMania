package com.ismail.creatvt.moviemania.api

import com.ismail.creatvt.moviemania.Utility
import com.ismail.creatvt.moviemania.Utility.API_KEY
import com.ismail.creatvt.moviemania.model.MovieItem
import com.ismail.creatvt.moviemania.model.MoviePageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieListService {

    @GET("movie/top_rated/")
    fun getTopRatedMovies(@Query("api_key") apiKey: String = API_KEY,
                          @Query("language") language: String = "en-US",
                          @Query("page") page: Int = 1): Call<MoviePageResponse>

    @GET("movie/popular/?api_key=${Utility.API_KEY}")
    fun getPopularMovies(): Call<MoviePageResponse>

    @GET("movie/latest/?api_key=${Utility.API_KEY}")
    fun getLatestMovies(): Call<MoviePageResponse>

    @GET("movie/upcoming/?api_key=${Utility.API_KEY}")
    fun getUpcomingMovies(): Call<MoviePageResponse>

}
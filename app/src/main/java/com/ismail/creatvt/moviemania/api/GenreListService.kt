package com.ismail.creatvt.moviemania.api

import com.ismail.creatvt.moviemania.Utility
import com.ismail.creatvt.moviemania.model.GenreItem
import com.ismail.creatvt.moviemania.model.GenreListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GenreListService {

    @GET("genre/movie/list")
    fun getGenreList(
        @Query("api_key") apiKey: String = Utility.API_KEY,
        @Query("language") language: String = "en-US"
    ): Call<GenreListResponse>

}
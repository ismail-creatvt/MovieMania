package com.ismail.creatvt.moviemania.model

import com.google.gson.annotations.SerializedName

class MovieItem(
    val id: Int,
    @SerializedName("poster_path") val posterPath : String,
    @SerializedName("backdrop_path") val backdropPath : String,
    @SerializedName("original_language") val originalLanguage : String,
    @SerializedName("original_title") val originalTitle : String,
    @SerializedName("genre_ids") val genreIds : Array<Int>,
    @SerializedName("title") val title: String,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("overview") val overview: String,
    @SerializedName("release_date") val releaseDate: String
)
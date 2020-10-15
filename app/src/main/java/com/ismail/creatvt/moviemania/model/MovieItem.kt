package com.ismail.creatvt.moviemania.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieItem(
    val id: Int,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("backdrop_path") var backdropPath: String,
    @SerializedName("original_language") var originalLanguage: String,
    @SerializedName("original_title") var originalTitle: String,
    @SerializedName("genre_ids") var genreIds: List<Int> = arrayListOf(),
    @SerializedName("title") val title: String,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("overview") val overview: String,
    @SerializedName("release_date") val releaseDate: String
)
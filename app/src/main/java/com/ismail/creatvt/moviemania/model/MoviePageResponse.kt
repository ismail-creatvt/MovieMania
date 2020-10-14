package com.ismail.creatvt.moviemania.model

import com.google.gson.annotations.SerializedName

class MoviePageResponse(
    val page:Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("results") val results: List<MovieItem>
)